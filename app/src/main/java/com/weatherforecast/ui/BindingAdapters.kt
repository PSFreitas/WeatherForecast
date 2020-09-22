package com.weatherforecast.ui

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("formatCelsius")
        fun formatCelsius(textView: TextView, temperature: Double) {
            val roundedUpTemperature = temperature.roundToInt()
            textView.text = "$roundedUpTemperature ℃"
        }

        @JvmStatic
        @BindingAdapter("formatTimeInMillis")
        fun formatTimeInMillisToCalendar(textView: TextView, timeInMillis: Long) {
            val calendar = Calendar.getInstance().apply { this.timeInMillis = timeInMillis }
            val formatter = SimpleDateFormat("dd/MM/YYYY")
            textView.text = formatter.format(calendar.time)
        }

        @JvmStatic
        @BindingAdapter("formatFeelsLikeTemperature")
        fun formatFeelsLikeTemperature(textView: TextView, temperature: Double) {
            val roundedTemperature = temperature.roundToInt()
            textView.text = "Sensação térmica: $roundedTemperature ℃"
        }
    }
}