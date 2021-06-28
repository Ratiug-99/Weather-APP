package com.ratiugdev.weatherapp.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun searchLocationsByName(locationName: String) =
        apiService.searchLocationsByName(locationName)

    suspend fun searchLocationsByLattlong(locationLattLong: String) =
        apiService.searchLocationsByLattlong(locationLattLong)

    suspend fun getLocation(woeid: Int) = apiService.getLocation(woeid)

    suspend fun getLocationDay(woeid: Int, date: String) = apiService.getLocationDay(woeid, date)

}