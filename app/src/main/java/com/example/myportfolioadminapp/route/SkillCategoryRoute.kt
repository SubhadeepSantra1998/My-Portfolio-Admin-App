package com.example.myportfolioadminapp.route


sealed class SkillCategoryRoute(val route: String) {
    data object Home : SkillCategoryRoute(route = Route.SKILL_CATEGORY.value)
    data object AddCategory : SkillCategoryRoute(route = Route.SKILL_ADD_CATEGORY.value)
    data object UpdateCategory : SkillCategoryRoute(route = Route.SKILL_UPDATE_CATEGORY.value)
}