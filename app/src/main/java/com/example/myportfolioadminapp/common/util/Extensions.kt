package com.example.myportfolioadminapp.common.util

fun Float.toPercentage(): String {
    val percentage = (this * 100).toInt()
    return "$percentage%"
}