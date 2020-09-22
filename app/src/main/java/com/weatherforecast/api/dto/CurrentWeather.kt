package com.weatherforecast.api.dto

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("dt") val timeInMillis: Long,
    @SerializedName("sunrise") val sunriseTimeInMillis: Long,
    @SerializedName("sunset") val sunsetTimeInMillis: Long,
    @SerializedName("temp") val temperatureInCelsius: Double,
    @SerializedName("feels_like") val feelsLikeTemperatureInCelsius: Double,
    @SerializedName("weather") val weatherDescription: List<WeatherDescription>

)
