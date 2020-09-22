package com.weatherforecast.repository

import com.weatherforecast.api.dto.NetworkCity
import com.weatherforecast.utils.ResultData

interface WeatherRepository {

    suspend fun getCurrentAndForecastWeather(
        cityLatitude: Double,
        cityLongitude : Double,
        apiKey:String
    ): ResultData<NetworkCity>
}