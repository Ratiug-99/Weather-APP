@file:Suppress("UNCHECKED_CAST")

package com.ratiugdev.weatherapp.ui.base

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ratiugdev.weatherapp.data.api.ApiHelper
import com.ratiugdev.weatherapp.data.repository.MainRepository
import com.ratiugdev.weatherapp.ui.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}