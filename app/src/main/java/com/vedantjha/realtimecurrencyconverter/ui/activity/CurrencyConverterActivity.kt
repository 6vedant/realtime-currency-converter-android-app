package com.vedantjha.realtimecurrencyconverter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vedantjha.realtimecurrencyconverter.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)
    }
}