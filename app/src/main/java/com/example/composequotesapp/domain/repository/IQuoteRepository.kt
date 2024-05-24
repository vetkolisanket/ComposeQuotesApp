package com.example.composequotesapp.domain.repository

import com.example.composequotesapp.models.Quote
import kotlinx.coroutines.flow.Flow

interface IQuoteRepository {

    suspend fun getQuotes(): Flow<List<Quote>>

    suspend fun getQuote(quote: String): Flow<Quote>

}