package com.weatherforecast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weatherforecast.R
import com.weatherforecast.databinding.ActivityMainBinding
import com.weatherforecast.repository.WeatherRepositoryImplementation
import com.weatherforecast.ui.adapter.ForecastAdapter
import com.weatherforecast.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val forecastAdapter = ForecastAdapter(mutableListOf())

    private val weatherViewModel by lazy {
        val weatherRepository = WeatherRepositoryImplementation()
        ViewModelProvider(
            this,
            WeatherViewModelFactory(weatherRepository)
        ).get(WeatherViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).let {
            it.lifecycleOwner = this
            it.viewModel = weatherViewModel
            it.root
        }
    }


    override fun onResume() {
        super.onResume()
        setupRecyclerView()
        setupObservers()
        weatherViewModel.getCurrentAndForecastWeather(
            -3.0445758,
            -60.002123113
        )
    }

    private fun setupObservers() {
        weatherViewModel.cityWeather.observe(
            this,
            Observer {
                if (it.status == Status.SUCCESS) {
                    it.data?.dailyWeatherForecasts?.let { forecastList ->
                        forecastAdapter.forecastWeatherList.addAll(
                            forecastList
                        )
                        forecastAdapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }

    private fun setupRecyclerView() {

        val itemDecoration = DividerItemDecoration(
            this,
            RecyclerView.VERTICAL
        ).apply {
            ContextCompat.getDrawable(this@MainActivity, R.drawable.item_vertical_divider)?.let {
                setDrawable(
                    it
                )
            }
        }

        recyclerView_forecast_weather.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.VERTICAL,
                false
            )
            addItemDecoration(itemDecoration)
            adapter = forecastAdapter
        }

    }
}