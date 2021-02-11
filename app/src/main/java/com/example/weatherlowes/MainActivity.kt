package com.example.weatherlowes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hide toolbar
        supportActionBar?.hide()

        val buttonLookup = findViewById<Button>(R.id.sendCity)
        val textCity = findViewById<EditText>(R.id.txtCity)

        buttonLookup.setOnClickListener {
            if (textCity.text.trim().isNotEmpty()) {
                val intent = Intent(this, WeatherListActivity::class.java)
                intent.putExtra("EXTRA_CITY", textCity.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_LONG).show()
            }
        }
    }

}