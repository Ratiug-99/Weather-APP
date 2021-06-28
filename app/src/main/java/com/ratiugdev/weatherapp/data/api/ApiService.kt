package com.ratiugdev.weatherapp.data.api

import com.ratiugdev.weatherapp.data.model.ConsolidatedLocation
import com.ratiugdev.weatherapp.data.model.Location
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("location/search")
    suspend fun searchLocationsByName(@Query("query") locationName: String): ArrayList<Location>

    @GET("location/search")
    suspend fun searchLocationsByLattlong(@Query("lattlong") locationLattLong: String): ArrayList<Location>

    @GET("location/{woeid}/")
    suspend fun getLocation(@Path("woeid") woeid: Int): ConsolidatedLocation

    @GET("/location/{woeid}/{date}/")
    suspend fun getLocationDay(woeid: Int, date: String): ConsolidatedLocation


}