package com.example.myportfolioadminapp.common.util

sealed class SnackiePosition {

    object Top: SnackiePosition()

    object Bottom: SnackiePosition()

    object Float: SnackiePosition()
}