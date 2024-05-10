package com.vedantjha.realtimecurrencyconverter.data.repository

import androidx.lifecycle.LiveData
import com.vedantjha.realtimecurrencyconverter.data.model.CurrencyExchangeRateResponse
import com.vedantjha.realtimecurrencyconverter.data.network.CurrencyConverterApiService
import com.vedantjha.realtimecurrencyconverter.utils.Constant
import javax.inject.Inject

class CurrencyConverterRepository @Inject constructor(private val currencyConverterApiService: CurrencyConverterApiService) {
    suspend fun getCurrentExchangeRate(baseCurrency: String, targetCurrency: String) =
        currencyConverterApiService.getExchangeRate(api_key =Constant.API_KEY, symbols = "$baseCurrency,$targetCurrency")

    suspend fun getAvailableCurrencies() =
        currencyConverterApiService.getAvailableCurrencies(api_key =Constant.API_KEY)

}