package com.example.domain.usecase

import com.example.domain.entity.BookDetailEntity
import com.example.domain.repository.BookRepository
import javax.inject.Inject

class GetBookDetail @Inject constructor(private val bookRepository: BookRepository) {

    suspend operator fun invoke(id: String): Result<BookDetailEntity?> =
        try {
            bookRepository.fetchBookDetail(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
}