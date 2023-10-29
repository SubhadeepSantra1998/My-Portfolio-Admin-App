package com.example.myportfolioadminapp.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.myportfolioadminapp.feature.my_skill.presentation.add_my_skill.AddMySkillScreen
import com.example.myportfolioadminapp.feature.my_skill.presentation.update_skill.UpdateSkillScreen
import com.example.myportfolioadminapp.route.MySkillRoute

fun NavGraphBuilder.skillNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = MySkillRoute.HomeSkill.route,
        route = Graph.MY_SKILL
    ) {

        composable(route = MySkillRoute.AddSkill.route) {
            AddMySkillScreen(navController)
        }
        composable(route = MySkillRoute.UpdateSkill.route+"/{skillId}") {
            UpdateSkillScreen(navController)
        }

    }
}