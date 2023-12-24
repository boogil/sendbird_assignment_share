package com.example.data.data


import com.google.gson.annotations.SerializedName

data class SearchedBooks(
    @SerializedName("books") val books: List<Book>? = null,
    @SerializedName("error") val error: String? = null,
    @SerializedName("page") val page: String? = null,
    @SerializedName("total") val total: String? = null
)