package com.example.composequotesapp.domain.use_case

import com.example.composequotesapp.domain.repository.IQuoteRepository
import com.example.composequotesapp.models.Quote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(val repository: IQuoteRepository) {

    suspend operator fun invoke(quoteText: String): Flow<Quote> {
        return repository.getQuote(quoteText)
    }

}