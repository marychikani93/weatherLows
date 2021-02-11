package com.example.weatherlowes.network.model

import java.io.Serializable

data class Weather(
    var id: Long,
    var main: String,
    var description: String
) : Serializable