package com.ratiugdev.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ratiugdev.weatherapp.data.repository.MainRepository
import com.ratiugdev.weatherapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun searchLocationByName(locationName: String) = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        try {
            emit(Resource.success(mainRepository.searchLocationsByName(locationName)))
        } catch (exception : Exception) {
            emit(Resource.error(null,exception.message ?: "Something went wrong"))
        }
    }

    fun searchLocationByCoordinate(locationName: String) = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        try {
            emit(Resource.success(mainRepository.searchLocationsByLattlong(locationName)))
        } catch (exception : Exception) {
            emit(Resource.error(null,exception.message ?: "Something went wrong"))
        }
    }

    fun getLocation(woeid: Int) = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        try {
            emit(Resource.success(mainRepository.getLocation(woeid)))
        } catch (exception : Exception) {
            emit(Resource.error(null,exception.message ?: "Something went wrong"))
        }
    }


}
//
//suspend fun searchLocationsByName(locationName: String): ArrayList<Location>
//
//suspend fun searchLocationsByLattlong(locationLattLong: String): ArrayList<Location>
//
//suspend fun getLocation(woeid: Int): ConsolidatedLocation
//
//suspend fun getLocationDay(woeid: Int, date: String): ConsolidatedLocation
