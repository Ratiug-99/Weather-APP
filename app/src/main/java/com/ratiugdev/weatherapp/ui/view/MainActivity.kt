package com.ratiugdev.weatherapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.ratiugdev.weatherapp.R
import com.ratiugdev.weatherapp.data.api.ApiClient
import com.ratiugdev.weatherapp.data.api.ApiHelper
import com.ratiugdev.weatherapp.ui.base.ViewModelFactory
import com.ratiugdev.weatherapp.ui.viewmodel.MainViewModel
import com.ratiugdev.weatherapp.utils.Status.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DBG | MainActivity"
    }

    private lateinit var mainViewModel: MainViewModel
//    private lateinit var resultSearchAdapter: ResultSearchAdapter

    private lateinit var recyclerViewResultSearch: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObserver()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiClient.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObserver() {

        mainViewModel.searchLocationByName("kiev").observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    LOADING -> {
                        Log.d(TAG, "setupObserver searchLocationByName LOADING")
                    }
                    SUCCESS -> {
                        Log.d(TAG, "setupObserver searchLocationByName SUCCESS")
                    }
                    ERROR -> {
                        Log.d(TAG, "setupObserver searchLocationByName ERROR - ${it.message}")
                    }
                }
            }
        })

//
//        mainViewModel.searchLocationByCoordinate("50.068,-5.316").observe(this, {
//            it?.let { resource ->
//                when (resource.status) {
//                    LOADING -> {
//                        Log.d(TAG, "setupObserver  searchLocationByName LOADING")
//                    }
//                    SUCCESS -> {
//                        Log.d(TAG, "setupObserver searchLocationByName SUCCESS")
//                    }
//                    ERROR -> {
//                        Log.d(TAG, "setupObserver searchLocationByName ERROR - ${it.message}")
//                    }
//                }
//            }
//        })

//        mainViewModel.getLocation(44418).observe(this, {
//            it?.let { resource ->
//                when (resource.status) {
//                    LOADING -> {
//                        Log.d(TAG, "setupObserver  getLocation LOADING")
//                    }
//                    SUCCESS -> {
//                        Log.d(TAG, "setupObserver getLocation SUCCESS")
//                    }
//                    ERROR -> {
//                        Log.d(TAG, "setupObserver getLocation ERROR - ${it.message}")
//                    }
//                }
//            }
//        })


    }

    private fun setupUI() {
        recyclerViewResultSearch = findViewById(R.id.rv_result_search)
    }


}