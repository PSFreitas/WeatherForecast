package com.weatherforecast.api.dto

import com.google.gson.annotations.SerializedName

data class NetworkCity(
    @SerializedName("timezone") val timeZone: String,
    @SerializedName("timezone_offset") val timeZoneOffSet: Long,
    @SerializedName("current") val currentWeather: CurrentWeather,
    @SerializedName("daily") val dailyWeatherForecasts: List<ForecastWeather>
)