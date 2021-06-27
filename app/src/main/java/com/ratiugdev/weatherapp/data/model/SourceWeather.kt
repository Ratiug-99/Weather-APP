package com.ratiugdev.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class SourceWeather(

    @SerializedName("title")
    val title : String?,

    @SerializedName("slug")
    val slug : String?,

    @SerializedName("url")
    val url : String?,

    @SerializedName("crawl_rate")
    val crawlRate : Int?,

)