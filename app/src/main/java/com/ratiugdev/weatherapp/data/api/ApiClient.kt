package com.ratiugdev.weatherapp.data.api

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val TAG = "DBG | ApiClient"
    private const val BASE_URL = "https://www.metaweather.com/api/"

    private val gson: Gson by lazy {
        Log.d(TAG, "create gson")
        GsonBuilder().setLenient().create()
    }

    private val okHttpClient: OkHttpClient by lazy {
        Log.d(TAG, "create httpLoggingInterceptor")
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        Log.d(TAG, "create okHttpClient")
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    private val retrofit : Retrofit by lazy {
        Log.d(TAG, "create retrofit")
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService :  ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }

}