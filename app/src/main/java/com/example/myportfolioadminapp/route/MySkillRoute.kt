package com.example.myportfolioadminapp.route


sealed class MySkillRoute(val route: String) {
    data object HomeSkill : MySkillRoute(route = Route.HOME_SKILL.value)
    data object AddSkill : MySkillRoute(route = Route.ADD_SKILL.value)
    data object UpdateSkill : MySkillRoute(route = Route.UPDATE_SKILL.value)
}