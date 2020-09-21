package com.weatherforecast.api

import com.weatherforecast.api.dto.NetworkCity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("onecall")
    suspend fun getCityCurrentAndForecastWeather(
        @Query("lat") cityLatitude: Double,
        @Query("lon") cityLongitude: Double,
        @Query("exclude") excludeFields: String,
        @Query("appid") apiKey: String,
        @Query("units") metricUnit : String
    ): Response<NetworkCity>
}
