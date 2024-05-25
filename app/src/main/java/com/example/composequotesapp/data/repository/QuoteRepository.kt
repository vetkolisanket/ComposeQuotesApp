package com.example.composequotesapp.data.repository

import com.example.composequotesapp.data.source.LocalDataSource
import com.example.composequotesapp.domain.repository.IQuoteRepository
import com.example.composequotesapp.models.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val localDataSource: LocalDataSource) :
    IQuoteRepository {
    override suspend fun getQuotes(): Flow<List<Quote>> {
        return withContext(Dispatchers.IO) { localDataSource.getQuotes() }
    }

    override suspend fun getQuote(quote: String): Flow<Quote> {
        return withContext(Dispatchers.IO) { localDataSource.getQuote(quote) }
    }
}