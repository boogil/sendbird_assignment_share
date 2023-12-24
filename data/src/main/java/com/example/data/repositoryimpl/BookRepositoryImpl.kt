package com.example.data.repositoryimpl

import com.example.data.mapper.toEntity
import com.example.data.service.BookService
import com.example.domain.entity.BookDetailEntity
import com.example.domain.entity.SearchedBooksEntity
import com.example.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val bookService: BookService) : BookRepository {
    override suspend fun fetchBooks(searchWord: String, page: Int): Result<SearchedBooksEntity> {
        return try {
            val result = bookService.fetchBooks(searchWord, page)
            Result.success(result.toEntity())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun fetchBookDetail(id: String): Result<BookDetailEntity> {
        return try {
            val result = bookService.fetchBookDetail(id)
            Result.success(result.toEntity())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}