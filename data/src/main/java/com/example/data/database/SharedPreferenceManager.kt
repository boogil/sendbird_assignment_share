package com.example.data.database

import android.content.Context

class SharedPreferenceManager(private val context: Context) {
    private val prefs by lazy { context.getSharedPreferences(KEY_SHARED_PREF_HOME, Context.MODE_PRIVATE) }

    fun setString(key: String, value: String) {
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    companion object {
        private const val KEY_SHARED_PREF_HOME = "key_shared_pref_home"
    }
}