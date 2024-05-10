package com.vedantjha.realtimecurrencyconverter.di

import android.content.Context
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun getRoomDatabase(context: Context): CurrencyConverterRoomDatabase {
        return CurrencyConverterRoomDatabase.getDatabase(context)
    }

}