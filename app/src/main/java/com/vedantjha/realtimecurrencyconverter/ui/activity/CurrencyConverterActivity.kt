package com.vedantjha.realtimecurrencyconverter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.vedantjha.realtimecurrencyconverter.R
import com.vedantjha.realtimecurrencyconverter.data.repository.CurrencyConverterRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CurrencyConverterActivity : AppCompatActivity() {
    @Inject lateinit var repository: CurrencyConverterRepository
    private val currencyConverterVieModel: CurrencyConverterViewModel by viewModels<CurrencyConverterViewModel> {
        CurrencyConverterViewModelFactory(repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)

        currencyConverterVieModel.getCurrencyExchangeRate("EUR", "INR")
        currencyConverterVieModel.currencyConverterResponseLiveData.observe(this, Observer {
            Log.d("CURRENCYVALUE", ""+it?.rates?.get("INR"))
        })

    }
}