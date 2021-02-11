package com.example.weatherlowes.network.model

import java.io.Serializable

data class WeatherObject(
    var dt: Long,
    var main: Main,
    var weather: ArrayList<Weather>
) : Serializable


