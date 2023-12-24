package com.example.data.service

import com.example.data.data.BookDetail
import com.example.data.data.SearchedBooks
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookService {
    @GET("search/{searchWord}/{page}")
    suspend fun fetchBooks(@Path("searchWord") searchWord: String = "shop",
                           @Path("page") page: Int = DEFAULT_START_PAGE): SearchedBooks

    @GET("books/{id}")
    suspend fun fetchBookDetail(@Path("id") bookId: String): BookDetail

    companion object {
        const val DEFAULT_START_PAGE = 1
    }
}