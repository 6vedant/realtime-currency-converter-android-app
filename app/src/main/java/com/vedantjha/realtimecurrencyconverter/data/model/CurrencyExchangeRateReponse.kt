package com.vedantjha.realtimecurrencyconverter.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyExchangeRateResponse(
    val success: Boolean? = false,
    val timestamp: Long? = 0,
    val base: String?,
    val date: String?,
    val rates: HashMap<String, Double>?
) : Parcelable
