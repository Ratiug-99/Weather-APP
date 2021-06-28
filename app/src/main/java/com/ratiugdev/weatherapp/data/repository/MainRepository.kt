package com.ratiugdev.weatherapp.data.repository

import com.ratiugdev.weatherapp.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun searchLocationsByName(locationName: String) =
        apiHelper.searchLocationsByName(locationName)

    suspend fun searchLocationsByLattlong(locationLattLong: String) =
        apiHelper.searchLocationsByLattlong(locationLattLong)

    suspend fun getLocation(woeid: Int) = apiHelper.getLocation(woeid)

    suspend fun getLocationDay(woeid: Int, date: String) = apiHelper.getLocationDay(woeid, date)

}