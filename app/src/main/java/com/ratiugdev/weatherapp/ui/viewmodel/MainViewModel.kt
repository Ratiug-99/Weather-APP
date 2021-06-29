package com.ratiugdev.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ratiugdev.weatherapp.data.model.Location
import com.ratiugdev.weatherapp.data.repository.MainRepository
import com.ratiugdev.weatherapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    val listResultSearch = MutableLiveData<Resource<List<Location>?>>()

    fun searchLocationByName(locationName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            listResultSearch.postValue(Resource.loading(null))
            try {
                listResultSearch.postValue(Resource.success(mainRepository.searchLocationsByName(locationName)))
            } catch (exception: Exception){
                listResultSearch.postValue(Resource.error(null,exception.message ?: "Something went wrong"))
            }
        }

    }

//    fun searchLocationByName(locationName: String) = liveData(Dispatchers.IO){
//        emit(Resource.loading(null))
//        try {
//            emit(Resource.success(mainRepository.searchLocationsByName(locationName)))
//        } catch (exception : Exception) {
//            emit(Resource.error(null,exception.message ?: "Something went wrong"))
//        }
//    }

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
