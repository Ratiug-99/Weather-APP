package com.ratiugdev.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(

    @SerializedName("id")
    val id: Long? = 0,

    @SerializedName("applicable_date")
    val applicableDate: String?,

    @SerializedName("weather_state_name")
    val weatherStateName: String?,

    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String?,

    @SerializedName("wind_speed")
    val windSpeed: Float?,

    @SerializedName("wind_direction")
    val windDirection: String?,

    @SerializedName("wind_direction_compass")
    val windDirectionCompass: String? = "N/A",

    @SerializedName("air_pressure")
    val airPressure: Float?,

    @SerializedName("humidity")
    val humidity: Float?,

    @SerializedName("visibility")
    val visibility: Float?,

    @SerializedName("predictability")
    val predictability: Int? = 0,
)