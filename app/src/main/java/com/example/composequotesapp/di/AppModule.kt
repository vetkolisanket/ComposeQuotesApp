package com.example.composequotesapp.di

import android.content.Context
import com.example.composequotesapp.data.LocalDataSource
import com.example.composequotesapp.domain.repository.IQuoteRepository
import com.example.composequotesapp.domain.use_case.GetQuotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesLocalDataSource(@ApplicationContext context: Context) = LocalDataSource(context)

    @Provides
    @Singleton
    fun providesGetQuotesUseCase(repository: IQuoteRepository) = GetQuotesUseCase(repository)

}