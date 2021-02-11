package com.example.weatherlowes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherlowes.network.model.WeatherObject

class WeatherItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_selected_item)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val txtTemp = findViewById<TextView>(R.id.txt_temp)
        val txtMain = findViewById<TextView>(R.id.txt_main)
        val txtDescription = findViewById<TextView>(R.id.txt_description)
        val txtFeelsLike = findViewById<TextView>(R.id.txt_feels_like)

        val dataWeatherSelected = intent.getSerializableExtra("EXTRA_DATA")
        dataWeatherSelected?.let {
            val weatherItem = it as WeatherObject
            txtTemp.text = weatherItem.main.temp.toString()
            txtFeelsLike.text =
                resources.getString(R.string.feels_like_80, weatherItem.main.feels_like.toString())
            txtDescription.text = weatherItem.weather[0].description
            txtMain.text = weatherItem.weather[0].main
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}