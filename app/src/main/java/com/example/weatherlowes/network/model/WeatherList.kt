package com.example.weatherlowes.network.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherList(@SerializedName("list") var weatherObject: List<WeatherObject>) :
    Serializable