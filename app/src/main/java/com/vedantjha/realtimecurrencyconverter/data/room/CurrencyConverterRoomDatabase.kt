package com.vedantjha.realtimecurrencyconverter.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vedantjha.realtimecurrencyconverter.data.model.Currency

@Database(entities = [Currency::class], version = 1, exportSchema = false)
abstract class CurrencyConverterRoomDatabase: RoomDatabase() {
    abstract fun currencyConverterDao(): CurrencyConverterDao
}