package com.weatherforecast.api.dto

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("dt") val timeInMillis: Long,
    @SerializedName("sunrise") val sunriseTimeInMillis: Long,
    @SerializedName("sunset") val sunsetTimeInMillis: Long,
    @SerializedName("temp") val temperatureInFahrenheit: Double,
    @SerializedName("feels_like") val feelsLikeTemperatureInFahrenheit: Double,
    @SerializedName("weather") val weatherDescription: List<WeatherDescription>

)
