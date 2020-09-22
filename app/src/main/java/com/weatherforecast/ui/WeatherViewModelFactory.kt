package com.weatherforecast.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weatherforecast.repository.WeatherRepositoryImplementation

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(
    private val weatherRepositoryImplementation: WeatherRepositoryImplementation
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(
            weatherRepositoryImplementation
        ) as T
    }
}