package com.example.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class BookDetailEntity(
    val authors: String? = null,
    val desc: String? = null,
    val error: String? = null,
    val image: String? = null,
    val isbn10: String? = null,
    val isbn13: String? = null,
    val language: String? = null,
    val pages: String? = null,
    val price: String? = null,
    val publisher: String? = null,
    val rating: String? = null,
    val subtitle: String? = null,
    val title: String? = null,
    val url: String? = null,
    val year: String? = null
) : Parcelable