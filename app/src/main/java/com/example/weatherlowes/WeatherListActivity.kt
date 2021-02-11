package com.example.weatherlowes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlowes.WeatherAdapter.OnItemClickedListener
import com.example.weatherlowes.network.model.WeatherList
import com.example.weatherlowes.viewmodels.WeatherViewModel

class WeatherListActivity : AppCompatActivity(), OnItemClickedListener {

    private val myViewModel by viewModels<WeatherViewModel>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: WeatherAdapter
    private var city: String? = null
    lateinit var mListWeather: WeatherList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        //showing the back button in toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeRecyclerView()

        city = intent.getStringExtra("EXTRA_CITY")
        city?.let {
            myViewModel.getDataResponse(city!!, getString(R.string.APIKey))
                .observe(
                    this
                ) {
                    it?.let {
                        mListWeather = it
                        adapter = WeatherAdapter(it, this)
                        recyclerView.adapter = adapter
                    } ?: run {
                        Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show()
                    }

                }
        }

    }


    private fun initializeRecyclerView() {
        recyclerView = findViewById(R.id.weather_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    override fun onItemClick(view: View, position: Int) {
        val intent = Intent(this@WeatherListActivity, WeatherItemActivity::class.java)
        intent.putExtra("EXTRA_DATA", mListWeather.weatherObject[position])
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}