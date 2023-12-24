package com.example.domain.usecase

import com.example.domain.entity.SearchedBooksEntity
import com.example.domain.repository.BookRepository
import javax.inject.Inject

class GetBooks @Inject constructor(private val bookRepository: BookRepository) {

    suspend operator fun invoke(searchWord: String, page: Int = 1): Result<SearchedBooksEntity> = bookRepository.fetchBooks(searchWord, page)
}