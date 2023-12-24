package com.example.domain.repository

import com.example.domain.entity.BookDetailEntity
import com.example.domain.entity.SearchedBooksEntity

interface BookRepository {
    suspend fun fetchBooks(searchWord: String, page: Int): Result<SearchedBooksEntity>

    suspend fun fetchBookDetail(id: String): Result<BookDetailEntity>
}