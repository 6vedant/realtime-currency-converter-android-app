package com.vedantjha.realtimecurrencyconverter.data.network

import com.vedantjha.realtimecurrencyconverter.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrencyConverterApiService {
    @GET("latest")
    fun getExchangeRate(
        @Query("access_key") api_key: String = Constant.API_KEY,
        @Query("symbols") symbols: String
    ): Response<CurrencyConverterApiService>
}