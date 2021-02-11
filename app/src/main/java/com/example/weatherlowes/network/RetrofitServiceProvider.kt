package com.example.weatherlowes.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceProvider {

    private val BASE_URL = "https://api.openweathermap.org/"

    private fun getRetrofitInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getAPIInstance(): WeatherService {
        return getRetrofitInstance().create(WeatherService::class.java)
    }
}