package com.example.presentation.extensions

fun <R, A, B> withNotNull(a: A?, b: B?, function: (A, B) -> R): R? {
    if (a != null && b != null) {
        return function(a, b)
    }
    return null
}


fun <R, A, B, C> withNotNull(a: A?, b: B?, c: C?, function: (A, B, C) -> R): R? {
    if (a != null && b != null && c != null) {
        return function(a, b, c)
    }
    return null
}

fun <R, A, B, C, D> withNotNull(a: A?, b: B?, c: C?, d: D?, function: (A, B, C, D) -> R): R? {
    if (a != null && b != null && c != null && d != null) {
        return function(a, b, c, d)
    }
    return null
}

fun <R> withNotNullNullOrBlank(a: String?, b: String?, function: (String, String) -> R): R? {
    if (a != null && a.isNotBlank() && b != null && b.isNotBlank()) {
        return function(a, b)
    }
    return null
}

fun <R, A, B> withNotNullOrEmpty(a: ArrayList<A>?, b: ArrayList<B>?, function: (ArrayList<A>, ArrayList<B>) -> R): R? {
    if (!a.isNullOrEmpty() && !b.isNullOrEmpty()) {
        return function(a, b)
    }
    return null
}