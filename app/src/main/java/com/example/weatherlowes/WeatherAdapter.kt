package com.example.weatherlowes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherlowes.network.model.WeatherList

class WeatherAdapter(private val weatherList: WeatherList, var listener: OnItemClickedListener) :
    RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_item, parent, false)

        context = parent.context
        return WeatherHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.itemTemp.text =
            context.getString(
                R.string.temp_72,
                weatherList.weatherObject[position].main.temp.toString()
            )
        holder.itemMain.text = weatherList.weatherObject[position].weather[0].main
    }

    override fun getItemCount(): Int {
        return weatherList.weatherObject.size
    }

    inner class WeatherHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        var itemMain: TextView
        var itemTemp: TextView

        init {
            itemMain = view.findViewById(R.id.item_main)
            itemTemp = view.findViewById(R.id.item_temp)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            listener.onItemClick(v, adapterPosition)
        }

    }

    interface OnItemClickedListener {
        fun onItemClick(view: View, position: Int)
    }
}

