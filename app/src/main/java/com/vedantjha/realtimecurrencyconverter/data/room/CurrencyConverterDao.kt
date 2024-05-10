package com.vedantjha.realtimecurrencyconverter.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vedantjha.realtimecurrencyconverter.data.model.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyConverterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currency: Currency)

    @Query("SELECT * FROM available_currencies ORDER BY CurrencyName ASC")
    fun getAllCurrencies(): Flow<List<Currency>>
}