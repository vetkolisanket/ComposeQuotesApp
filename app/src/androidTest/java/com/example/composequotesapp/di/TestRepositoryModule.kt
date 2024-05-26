package com.example.composequotesapp.di

import com.example.composequotesapp.data.repository.FakeQuoteRepository
import com.example.composequotesapp.domain.repository.IQuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface TestRepositoryModule {

    @Binds
    @Singleton
    fun bindQuoteRepository(repository: FakeQuoteRepository): IQuoteRepository

}