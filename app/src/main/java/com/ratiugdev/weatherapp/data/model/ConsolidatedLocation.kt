package com.ratiugdev.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class ConsolidatedLocation(
    @SerializedName("title")
    val titleLocation : String? = "N/A Name Location",

    @SerializedName("location_type")
    val typeLocation : String? = "N/A  Location Type",

    @SerializedName("latt_long")
    val coordinateLocation : Float? = 0.0f,

    @SerializedName("woeid")
    val woeidLocation : Int? = 0,

    @SerializedName("time")
    val timeInLocation : String?,

    @SerializedName("sun_rise")
    val sunriseTimeInLocation : String?,

    @SerializedName("sun_set")
    val sunsetInLocation : String?,

    @SerializedName("timezone_name")
    val timeZoneNameLocation : String?,

    @SerializedName("parent")
    val parentLocation : Location?,

    @SerializedName("source")
    val sourceWeatherLocation : ArrayList<SourceWeather>?,

    @SerializedName("consolidated_weather")
    val consolidateWeatherLocation : ArrayList<ConsolidatedWeather>,



)
