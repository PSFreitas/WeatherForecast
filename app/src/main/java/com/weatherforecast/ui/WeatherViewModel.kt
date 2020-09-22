package com.weatherforecast.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherforecast.BuildConfig
import com.weatherforecast.api.dto.NetworkCity
import com.weatherforecast.repository.WeatherRepositoryImplementation
import com.weatherforecast.utils.Resource
import com.weatherforecast.utils.ResultData
import kotlinx.coroutines.launch

class WeatherViewModel(
    val weatherRepositoryImplementation: WeatherRepositoryImplementation
) : ViewModel() {

    private val _cityWeather = MutableLiveData<Resource<NetworkCity>>()

    val cityWeather: LiveData<Resource<NetworkCity>> = _cityWeather
    
    fun getCurrentAndForecastWeather(
        cityLatitude: Double,
        cityLongitude: Double
    ) {

        _cityWeather.value = Resource.loading()

        viewModelScope.launch {
            val response =
                weatherRepositoryImplementation.getCurrentAndForecastWeather(
                    cityLatitude = cityLatitude,
                    cityLongitude = cityLongitude,
                    apiKey = BuildConfig.WEATHER_API_KEY
                )

            if (response is ResultData.Success) {
                _cityWeather.value = Resource.success(response.data)
            } else {
                _cityWeather.value = Resource.error(Exception())
            }

        }
    }
}