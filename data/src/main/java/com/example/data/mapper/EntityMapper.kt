package com.example.data.mapper

import com.example.data.data.BookDetail
import com.example.data.data.SearchedBooks
import com.example.domain.entity.BookDetailEntity
import com.example.domain.entity.BookEntity
import com.example.domain.entity.SearchedBooksEntity

internal fun SearchedBooks.toEntity(): SearchedBooksEntity = SearchedBooksEntity(
    books = books?.map { BookEntity(image = it.image, isbn13 = it.isbn13, price = it.price, subtitle = it.subtitle, title = it.title, url = it.url) }
        ?: emptyList(),
    error = error,
    page = page,
    total = total
)

internal fun BookDetail.toEntity(): BookDetailEntity = BookDetailEntity(
    authors = authors, desc = desc, error = error, image = image, isbn10 = isbn10,
    isbn13 = isbn13, language = language, pages = pages,
    publisher = publisher, rating = rating, subtitle = subtitle, title = title, url = url,
    year = year, price = price
)
