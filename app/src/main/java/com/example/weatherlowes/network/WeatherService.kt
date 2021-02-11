package com.example.weatherlowes.network

import com.example.weatherlowes.network.model.WeatherList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/data/2.5/forecast")
    fun getWeather(@Query("q") city: String, @Query("appid") apiKey: String): Call<WeatherList>
}