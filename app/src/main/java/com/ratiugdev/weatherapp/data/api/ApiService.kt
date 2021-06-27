package com.ratiugdev.weatherapp.data.api

import com.ratiugdev.weatherapp.data.model.Location
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/location/search/?query={query}")
    suspend fun searchLocationsByName(locationName : String) : Response<ArrayList<Location>>

    @GET("/location/search/?lattlong={latt}.{long}")
    suspend fun searchLocationsByLattlong(locationLattLong : String) : Response<ArrayList<Location>>

    @GET("/location/{woeid}/")
    suspend fun getLocation(woeid: Int)

    @GET("/location/{woeid}/{date}/")
    suspend fun getLocationDay(woeid : Int, date : String)

}