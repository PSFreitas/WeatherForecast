package com.weatherforecast.api.dto

import com.google.gson.annotations.SerializedName

data class NetworkTemperature(
    @SerializedName("day") val dayTemperatureInFahrenheit: Double,
    @SerializedName("min") val minTemperatureInFahrenheit: Double,
    @SerializedName("max") val maxTemperatureInFahrenheit: Double,
    @SerializedName("night") val nightTemperatureInFahrenheit: Double,
    @SerializedName("eve") val eveningTemperatureInFahrenheit: Double,
    @SerializedName("morn") val morningTemperatureInFahrenheit: Double
)
