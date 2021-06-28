package com.ratiugdev.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("title")
    val titleLocation : String? = "N/A Name Location",

    @SerializedName("location_type")
    val typeLocation : String? = "N/A Name Location",

    @SerializedName("latt_long")
    val coordinateLocation : String? = "",

    @SerializedName("woeid")
    val woeidLocation : Int? = 0,

    @SerializedName("distance")
    val distanceToLocation : Int?
)