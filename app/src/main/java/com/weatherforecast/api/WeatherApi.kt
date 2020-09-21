package com.weatherforecast.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface WeatherApi {

    companion object {

        const val WEATHER_URL = "https://api.openweathermap.org/data/2.5/"

        fun getInstance(): Retrofit =
            Retrofit.Builder().baseUrl(
                WEATHER_URL
            ).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

        fun getWeatherService(): WeatherService = getInstance().create(WeatherService::class.java)


    }
}