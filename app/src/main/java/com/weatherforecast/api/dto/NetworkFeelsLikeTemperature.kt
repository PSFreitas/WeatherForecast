package com.weatherforecast.api.dto

import com.google.gson.annotations.SerializedName

data class NetworkFeelsLikeTemperature(
    @SerializedName("day") val dayTemperatureInFahrenheit: Double,
    @SerializedName("night") val nightTemperatureInFahrenheit: Double,
    @SerializedName("eve") val eveningTemperatureInFahrenheit: Double,
    @SerializedName("morn") val morningTemperatureInFahrenheit: Double
)
