package com.example.presentation.extensions

import android.os.Build
import android.os.Bundle

fun <T> Bundle.getParcelableArrayEx(key: String, clazz: Class<T>): Array<out T?>? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableArray(key, clazz)
    } else {
        getParcelableArray(key)
    } as Array<T?>?
}

fun <T> Bundle.getParcelableEx(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key, clazz)
    } else {
        getParcelable(key)
    }
}