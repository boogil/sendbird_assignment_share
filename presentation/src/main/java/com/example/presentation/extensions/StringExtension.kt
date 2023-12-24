package com.example.presentation.extensions

import android.annotation.SuppressLint
import android.text.Html
import android.text.Spanned
import java.text.SimpleDateFormat
import java.util.Locale

@SuppressLint("SimpleDateFormat")
fun String?.toDateTimeFromIso8610(wantPattern: String): String? = kotlin.runCatching {
    this?.let { SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.KOREAN).parse(it)?.let { SimpleDateFormat(wantPattern).format(it) } }
}.getOrNull()

fun String?.fromHtml(): Spanned? {
    return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
}