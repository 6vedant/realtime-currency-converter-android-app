package com.vedantjha.realtimecurrencyconverter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.vedantjha.realtimecurrencyconverter.R
import com.vedantjha.realtimecurrencyconverter.data.repository.CurrencyConverterRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CurrencyConverterActivity : AppCompatActivity() {
    @Inject lateinit var repository: CurrencyConverterRepository
//    private val currencyConverterViewModel: CurrencyConverterViewModel by viewModels<CurrencyConverterViewModel> {
//        CurrencyConverterViewModelFactory(repository)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)

//        currencyConverterViewModel.getCurrencyExchangeRate("EUR", "INR")
//        currencyConverterViewModel.currencyConverterResponseLiveData.observe(this, Observer {
//            Log.d("CURRENCYVALUE", ""+it?.rates?.get("INR"))
//        })
//
//        currencyConverterViewModel.availableCurrenciesLiveData.observe(this, Observer {
//            Log.d("CURRENCYVALUE", ""+it?.size)
//
//            Toast.makeText(applicationContext, "list: "+it?.size, Toast.LENGTH_SHORT).show()
//        })

    }
}