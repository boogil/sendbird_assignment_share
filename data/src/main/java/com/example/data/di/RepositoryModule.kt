package com.example.data.di

import com.example.data.repositoryimpl.BookRepositoryImpl
import com.example.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {
    @Singleton
    @Binds
    internal abstract fun bindBookRepository(
        bookRepository: BookRepositoryImpl
    ): BookRepository
}