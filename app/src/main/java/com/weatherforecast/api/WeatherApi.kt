package com.weatherforecast.api

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApi(
     context: Context
) {

    val WEATHER_URL = "https://api.openweathermap.org/data/2.5/"

    val cacheSize: Long = 10 * 1024 * 1024
    val cache: Cache = Cache(context.cacheDir, cacheSize)
    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().cache(cache).build()
    }

    val retrofit by lazy {
        Retrofit.Builder().baseUrl(
            WEATHER_URL
        ).client(
            okHttpClient
        ).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }

    val weatherService: WeatherService by lazy { retrofit.create(WeatherService::class.java) }


}