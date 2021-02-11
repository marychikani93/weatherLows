package com.example.weatherlowes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherlowes.network.model.WeatherList
import com.example.weatherlowes.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class WeatherViewModel : ViewModel() {

    private var repository: WeatherRepository = WeatherRepository()
    lateinit var myWeatherData: LiveData<WeatherList>
    var mCity: MutableLiveData<String> = MutableLiveData("")
    var mApiKey: MutableLiveData<String> = MutableLiveData("")


    fun getDataResponse(city: String, apiKey: String): LiveData<WeatherList> {

        mCity.value = city
        mApiKey.value = apiKey

        runBlocking {
            myWeatherData =
                withContext(Dispatchers.Default) {
                    repository.getWeatherData(
                        mCity.value.toString(),
                        mApiKey.value.toString()
                    )
                }
        }
        return myWeatherData
    }

}