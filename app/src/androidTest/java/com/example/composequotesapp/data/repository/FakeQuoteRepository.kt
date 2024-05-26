package com.example.composequotesapp.data.repository

import com.example.composequotesapp.domain.repository.IQuoteRepository
import com.example.composequotesapp.models.Quote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeQuoteRepository @Inject constructor() : IQuoteRepository {

    private val quotes = mutableListOf(
        Quote("1", "a"),
        Quote("2", "b")
    )

    override suspend fun getQuotes(): Flow<List<Quote>> {
        return flow { emit(quotes) }
    }

    override suspend fun getQuote(quoteText: String): Flow<Quote> {
        return flow { quotes.find { quote -> quote.text == quoteText }?.let { emit(it) } }
    }
}