package com.vedantjha.realtimecurrencyconverter

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vedantjha.realtimecurrencyconverter.data.model.Currency
import com.vedantjha.realtimecurrencyconverter.data.repository.CurrencyConverterRepository
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterDao
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterRoomDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@HiltAndroidApp
class CurrencyConverterApplication: Application() {
    companion object {
        private var sInstance: CurrencyConverterApplication? = null

        val instance: CurrencyConverterApplication
            @Throws(RuntimeException::class)
            get() {
                if (sInstance == null) throw RuntimeException((sInstance as CurrencyConverterApplication).getString(R.string.no_instance_found))
                return sInstance as CurrencyConverterApplication
            }
    }

    override fun onCreate() {
        super.onCreate()
        if (sInstance == null) {
            sInstance = this
        }
    }
}