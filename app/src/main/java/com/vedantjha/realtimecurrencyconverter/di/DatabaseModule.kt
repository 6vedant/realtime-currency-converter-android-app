package com.vedantjha.realtimecurrencyconverter.di

import android.content.Context
import androidx.room.Room
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterDao
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.internal.aggregatedroot.codegen._com_vedantjha_realtimecurrencyconverter_CurrencyConverterApplication
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun getRoomDatabase(@ApplicationContext context: Context): CurrencyConverterRoomDatabase {
        return Room.databaseBuilder(context, CurrencyConverterRoomDatabase::class.java, "currency_room_database").build()
    }


    @Provides
    fun getDatabaseDao(database: CurrencyConverterRoomDatabase): CurrencyConverterDao {
        return database.currencyConverterDao()
    }

}