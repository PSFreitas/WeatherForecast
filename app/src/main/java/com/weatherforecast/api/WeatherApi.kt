package com.weatherforecast.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApi {

    val WEATHER_URL = "https://api.openweathermap.org/data/2.5/"

    val retrofit by lazy {
        Retrofit.Builder().baseUrl(
            WEATHER_URL
        ).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }

    val weatherService: WeatherService by lazy { retrofit.create(WeatherService::class.java) }


}