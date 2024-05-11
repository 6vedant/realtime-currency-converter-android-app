package com.vedantjha.realtimecurrencyconverter.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.vedantjha.realtimecurrencyconverter.R
import com.vedantjha.realtimecurrencyconverter.data.repository.CurrencyConverterRepository
import com.vedantjha.realtimecurrencyconverter.databinding.ActivityCurrencyConverterBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CurrencyConverterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCurrencyConverterBinding
    @Inject
    lateinit var repository: CurrencyConverterRepository
    private val currencyConverterViewModel: CurrencyConverterViewModel by viewModels<CurrencyConverterViewModel> {
        CurrencyConverterViewModelFactory(repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCurrencyConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        currencyConverterViewModel.getAllAvailableCurrencies()



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