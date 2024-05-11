package com.vedantjha.realtimecurrencyconverter.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.vedantjha.realtimecurrencyconverter.data.model.Currency
import com.vedantjha.realtimecurrencyconverter.data.model.CurrencyExchangeRateResponse
import com.vedantjha.realtimecurrencyconverter.data.network.CurrencyConverterApiService
import com.vedantjha.realtimecurrencyconverter.data.room.CurrencyConverterDao
import com.vedantjha.realtimecurrencyconverter.utils.Constant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class CurrencyConverterRepository @Inject constructor(private val currencyConverterApiService: CurrencyConverterApiService) {

    @Inject
    lateinit var currencyConverterDao: CurrencyConverterDao

    suspend fun getCurrentExchangeRate(baseCurrency: String, targetCurrency: String) =
        currencyConverterApiService.getExchangeRate(
            apiKey = Constant.API_KEY,
            symbols = "$baseCurrency,$targetCurrency"
        )

    suspend fun getAllAvailableCountries(): List<Currency>? {
        // Fetch data from local database
        val localData = getAllAvailableCurrenciesFromLocalDatabase()

        // Fetch data from network in parallel
        val networkDataDeferred = CoroutineScope(Dispatchers.IO).async {
            getAvailableCurrenciesFromNetwork()
        }

        // Wait for network data to be fetched
        val networkData = networkDataDeferred.await()

        // Update local database with network data
        if (networkData.isSuccessful) {
            val countriesList =
                networkData.body()?.symbols?.map { (key, value) -> Currency(key, value) }
            countriesList.let {
                currencyConverterDao.deleteAll()
                currencyConverterDao.insertAll(countriesList)
                return countriesList
            }

        }
        return localData
    }

    private suspend fun getAvailableCurrenciesFromNetwork() =
        currencyConverterApiService.getAvailableCurrencies(apiKey = Constant.API_KEY)

    private suspend fun getAllAvailableCurrenciesFromLocalDatabase() =
        currencyConverterDao.getAllCurrencies()

    suspend fun addCurrency(currency: Currency) = currencyConverterDao.insert(currency)

    suspend fun deleteAllCurrencies() = currencyConverterDao.deleteAll()
}