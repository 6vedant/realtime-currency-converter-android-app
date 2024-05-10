package com.vedantjha.realtimecurrencyconverter.data.network

import com.vedantjha.realtimecurrencyconverter.data.model.CurrencyExchangeRateResponse
import com.vedantjha.realtimecurrencyconverter.data.model.CurrencySymbolResponse
import com.vedantjha.realtimecurrencyconverter.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrencyConverterApiService {

    @GET("symbols")
    suspend fun getAvailableCurrencies(
        @Query("access_key") api_key: String = Constant.API_KEY,
    ): Response<CurrencySymbolResponse>

    @GET("latest")
    suspend fun getExchangeRate(
        @Query("access_key") api_key: String = Constant.API_KEY,
        @Query("symbols", encoded = true) symbols: String
    ): Response<CurrencyExchangeRateResponse>


}