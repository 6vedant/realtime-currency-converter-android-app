package com.vedantjha.realtimecurrencyconverter.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vedantjha.realtimecurrencyconverter.data.model.Currency

@Dao
interface CurrencyConverterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currency: Currency): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(order: List<Currency>?)

    @Query("SELECT * FROM `available_currencies`")
    suspend fun getAllCurrencies(): List<Currency>

    @Query("DELETE FROM available_currencies")
    suspend fun deleteAll()
}