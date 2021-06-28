package com.ratiugdev.weatherapp.data.api

import com.ratiugdev.weatherapp.data.model.ConsolidatedLocation
import com.ratiugdev.weatherapp.data.model.Location
import retrofit2.http.GET

interface ApiService {

    @GET("/location/search/?query={query}")
    suspend fun searchLocationsByName(locationName: String): ArrayList<Location>

    @GET("/location/search/?lattlong={latt}.{long}")
    suspend fun searchLocationsByLattlong(locationLattLong: String): ArrayList<Location>

    @GET("/location/{woeid}/")
    suspend fun getLocation(woeid: Int): ConsolidatedLocation

    @GET("/location/{woeid}/{date}/")
    suspend fun getLocationDay(woeid: Int, date: String): ConsolidatedLocation

}