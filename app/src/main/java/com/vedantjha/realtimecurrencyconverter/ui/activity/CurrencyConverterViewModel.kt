package com.vedantjha.realtimecurrencyconverter.ui.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vedantjha.realtimecurrencyconverter.data.model.CurrencyExchangeRateResponse
import com.vedantjha.realtimecurrencyconverter.data.repository.CurrencyConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.inject.Inject

class CurrencyConverterViewModel @Inject constructor(private val repository: CurrencyConverterRepository) :
    ViewModel() {
    val currencyConverterResponseLiveData = MutableLiveData<CurrencyExchangeRateResponse>()

    fun getCurrencyExchangeRate(baseCurrency: String, targetCurrency: String) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.getCurrentExchangeRate(baseCurrency, targetCurrency)
                }
                Log.d("CURRENCYVALUE", "BODY: "+response.toString())
                Log.d("CURRENCYVALUE", "ERROR: "+response.errorBody())

                currencyConverterResponseLiveData.postValue(response.body())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

class CurrencyConverterViewModelFactory(private val repository: CurrencyConverterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CurrencyConverterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CurrencyConverterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}