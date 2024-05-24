package com.example.composequotesapp.domain.use_case

import com.example.composequotesapp.domain.repository.IQuoteRepository
import com.example.composequotesapp.models.Quote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: IQuoteRepository) {

    suspend operator fun invoke(): Flow<List<Quote>> {
        return repository.getQuotes()
    }

}