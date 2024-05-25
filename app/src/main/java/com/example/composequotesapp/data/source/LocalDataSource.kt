package com.example.composequotesapp.data.source

import android.content.Context
import com.example.composequotesapp.models.Quote
import com.example.composequotesapp.util.QuoteNotFoundException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val context: Context) {

    var data: List<Quote>? = null
    suspend fun getQuotes(): Flow<List<Quote>> {
        return flow {
            if (data == null) {
                val inputStream = context.assets.open("quotes.json")
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                val json = String(buffer, Charsets.UTF_8)
                data = Gson().fromJson(json, object : TypeToken<List<Quote>>() {}.type)
            }
            emit(data!!)
        }.flowOn(Dispatchers.IO)
    }

    @Throws(QuoteNotFoundException::class)
    fun getQuote(quoteText: String): Flow<Quote> = flow {
        data?.let { quotes ->
            quotes.find {
                it.text == quoteText
            }?.let { quote ->
                emit(quote)
            } ?: throw QuoteNotFoundException("Quote note found")
        }
    }.flowOn(Dispatchers.Default)
}