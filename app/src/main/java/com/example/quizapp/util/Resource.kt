package com.example.quizapp.util

/**
 * Helper class for APi calls  taken for here:
 * https://github.com/philipplackner/WeatherApp/blob/master/app/src/main/java/com/plcoding/weatherapp/domain/util/Resource.kt
 */

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}