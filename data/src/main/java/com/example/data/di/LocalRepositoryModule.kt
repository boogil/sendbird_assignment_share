package com.example.data.di

import android.content.Context
import com.example.data.database.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class LocalRepositoryModule {
    @Singleton
    @Provides
    fun provideSharedPreferenceManager(@ApplicationContext app: Context) = SharedPreferenceManager(app)
}