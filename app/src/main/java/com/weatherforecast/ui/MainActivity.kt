package com.weatherforecast.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.weatherforecast.R
import com.weatherforecast.databinding.ActivityMainBinding
import com.weatherforecast.repository.WeatherRepositoryImplementation

class MainActivity : AppCompatActivity() {


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
        weatherViewModel.getCurrentAndForecastWeather(
            3.0445758,
            -60.0021231
        )
    }
}