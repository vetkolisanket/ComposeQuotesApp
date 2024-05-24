package com.example.composequotesapp.di

import com.example.composequotesapp.data.repository.QuoteRepository
import com.example.composequotesapp.domain.repository.IQuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindQuoteRepository(repository: QuoteRepository): IQuoteRepository

}