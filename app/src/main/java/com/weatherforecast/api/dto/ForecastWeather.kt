package com.weatherforecast.api.dto

import com.google.gson.annotations.SerializedName

data class ForecastWeather(
    @SerializedName("dt") val forecastTimeInMillis: Long,
    @SerializedName("sunrise") val sunriseTimeInMillis: Long,
    @SerializedName("sunset") val sunsetTimeInMillis: Long,
    @SerializedName("temp") val temperature : NetworkTemperature,
    @SerializedName("feels_like") val feelsLikeTemperature : NetworkFeelsLikeTemperature,
    @SerializedName("weather") val weather: List<WeatherDescription>
)
