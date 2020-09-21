package com.weatherforecast.repository

import com.weatherforecast.api.WeatherApi
import com.weatherforecast.api.WeatherService
import com.weatherforecast.api.dto.NetworkCity
import com.weatherforecast.utils.ResultData
import kotlinx.coroutines.coroutineScope

class WeatherRepositoryImplementation(
    val weatherService: WeatherService = WeatherApi().weatherService
) : WeatherRepository {

    override suspend fun getCurrentAndForecastWeather(
        cityLatitude: Double,
        cityLongitude: Double,
        apiKey: String
    ): ResultData<NetworkCity> = coroutineScope {
        try {
            val response = weatherService.getCityCurrentAndForecastWeather(
                cityLatitude = cityLatitude,
                cityLongitude = cityLongitude,
                excludeFields = "minutely,hourly",
                apiKey = apiKey
            )
            if (response.isSuccessful && response.body() != null) {
                ResultData.Success(data = response.body()!!)
            } else
                ResultData.Error(exception = Exception())
        } catch (exception: Exception) {
            ResultData.Error(exception)
        }
    }
}