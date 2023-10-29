package com.example.myportfolioadminapp.route

sealed class MyEducationRoute(val route: String) {
    data object Education : MyEducationRoute(route = Route.EDUCATION.value)
    data object AddEducation : MyEducationRoute(route = Route.ADD_EDUCATION.value)
    data object UpdateEducation : MyEducationRoute(route = Route.UPDATE_EDUCATION.value)
}