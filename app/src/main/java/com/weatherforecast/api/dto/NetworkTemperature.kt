package com.weatherforecast.api.dto

import com.google.gson.annotations.SerializedName

data class NetworkTemperature(
    @SerializedName("day") val dayTemperatureInCelsius: Double,
    @SerializedName("min") val minTemperatureInCelsius: Double,
    @SerializedName("max") val maxTemperatureInCelsius: Double,
    @SerializedName("night") val nightTemperatureInCelsius: Double,
    @SerializedName("eve") val eveningTemperatureInCelsius: Double,
    @SerializedName("morn") val morningTemperatureInCelsius: Double
)
