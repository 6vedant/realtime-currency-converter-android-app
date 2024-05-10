package com.vedantjha.realtimecurrencyconverter.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencySymbolResponse(
    val success: Boolean? = false,
    val symbols: HashMap<String, String>?
) : Parcelable
