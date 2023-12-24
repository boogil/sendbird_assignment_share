package com.example.sendbird.initializer

import android.content.Context
import androidx.startup.Initializer
import com.example.data.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant()
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}