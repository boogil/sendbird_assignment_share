package com.example.domain.entity

data class SearchedBooksEntity(
    val books: List<BookEntity> = emptyList(),
    val error: String? = null,
    val page: String? = null,
    val total: String? = null
)