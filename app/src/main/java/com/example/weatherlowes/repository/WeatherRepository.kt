package com.example.weatherlowes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherlowes.network.RetrofitServiceProvider
import com.example.weatherlowes.network.model.WeatherList
import com.example.weatherlowes.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    var weatherService: WeatherService = RetrofitServiceProvider().getAPIInstance()

    fun getWeatherData(city: String, apiKey: String): LiveData<WeatherList> {
        val weatherData = MutableLiveData<WeatherList>()

        weatherService.getWeather(city, apiKey).enqueue(object : Callback<WeatherList> {
            override fun onResponse(call: Call<WeatherList>, response: Response<WeatherList>) {
                weatherData.value = response.body()
            }

            override fun onFailure(call: Call<WeatherList>, t: Throwable) {
                weatherData.value = null
            }
        })

        return weatherData
    }

}