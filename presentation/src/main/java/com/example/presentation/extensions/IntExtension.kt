package com.example.presentation.extensions

import java.text.DecimalFormat

fun Int?.setDecimalFormat(): String {
    val formatter = DecimalFormat("###,###")
    return runCatching {
        this?.let { formatter.format(it) } ?: ""
    }.getOrDefault("")
}

fun String?.setDecimalFormat(): String {
    val formatter = DecimalFormat("###,###")
    return runCatching {
        this?.let { formatter.format(Integer.parseInt(it)) } ?: ""
    }.getOrDefault("")
}
