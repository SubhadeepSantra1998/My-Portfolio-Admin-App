package com.example.myportfolioadminapp.route


sealed class EducationCategoryRoute(val route: String) {
    data object Home : EducationCategoryRoute(route = Route.EDUCATION_CATEGORY.value)
    data object AddCategory : EducationCategoryRoute(route = Route.EDUCATION_ADD_CATEGORY.value)
    data object UpdateCategory : EducationCategoryRoute(route = Route.EDUCATION_UPDATE_CATEGORY.value)
}