package com.weatherforecast.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.weatherforecast.R
import com.weatherforecast.api.dto.ForecastWeather
import com.weatherforecast.databinding.ItemWeatherForecastBinding

class ForecastAdapter(
    val forecastWeatherList: List<ForecastWeather>
) : RecyclerView.Adapter<
        ForecastAdapter.ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val binding = DataBindingUtil.inflate<ItemWeatherForecastBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_weather_forecast,
            parent,
            false
        )
        return ForecastViewHolder(binding)
    }

    override fun getItemCount(): Int = forecastWeatherList.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) =
        holder.bind(forecastWeatherList[position])

    class ForecastViewHolder(val binding: ItemWeatherForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(forecastWeather: ForecastWeather) {
            binding.forecastWeather = forecastWeather
        }

    }

}