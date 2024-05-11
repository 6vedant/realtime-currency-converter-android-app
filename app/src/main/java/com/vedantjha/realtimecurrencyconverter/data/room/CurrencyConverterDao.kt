package com.vedantjha.realtimecurrencyconverter.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vedantjha.realtimecurrencyconverter.data.model.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyConverterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currency: Currency): Long

    @Query("SELECT * FROM `available_currencies`")
    suspend fun getAllCurrencies(): List<Currency>
}