package com.example.weatherlowes.network.model

import java.io.Serializable

data class Main(
    var temp: Double,
    var feels_like: Double
) : Serializable