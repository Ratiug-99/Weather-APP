package com.ratiugdev.weatherapp.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ratiugdev.weatherapp.R
import com.ratiugdev.weatherapp.adapter.LocationAdapter
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
    private  var adapter = LocationAdapter(arrayListOf())
//    private lateinit var resultSearchAdapter: ResultSearchAdapter

    private lateinit var recyclerViewResultSearch: RecyclerView
    private lateinit var etSearchLocation: EditText
    private lateinit var pbLoadingResult: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupListeners()
        setupObserver()
    }


    private fun setupUI() {
        recyclerViewResultSearch = findViewById(R.id.rv_result_search)
        recyclerViewResultSearch.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        etSearchLocation = findViewById(R.id.et_search_location)
        pbLoadingResult = findViewById(R.id.pb_loading_search_location)
    }

    private fun setupListeners() {
        etSearchLocation.doAfterTextChanged {
            mainViewModel.searchLocationByName(it.toString())
        }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiClient.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObserver() {

        mainViewModel.listResultSearch.observe(this, { it ->
            it?.let { resource ->
                when (resource.status) {
                    LOADING -> {
                        Log.d(TAG, "setupObserver searchLocationByName LOADING")
                        pbLoadingResult.visibility = VISIBLE
//                        recyclerViewResultSearch.visibility = GONE
                    }
                    SUCCESS -> {
                        Log.d(TAG, "setupObserver searchLocationByName SUCCESS ${it.data}")
                        pbLoadingResult.visibility = GONE
                        recyclerViewResultSearch.visibility = VISIBLE
                        it.data?.let {
                            adapter.swap(it)
                        }
                    }
                    ERROR -> {
                        Log.d(TAG, "setupObserver searchLocationByName ERROR - ${it.message}")
                        pbLoadingResult.visibility = GONE
                        recyclerViewResultSearch.visibility = GONE
                    }
                }
            }
        })


    }


}