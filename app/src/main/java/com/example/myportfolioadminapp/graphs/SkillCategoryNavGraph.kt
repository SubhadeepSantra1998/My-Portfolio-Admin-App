package com.example.myportfolioadminapp.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.myportfolioadminapp.feature.skill_category.presentation.add_category.AddSkillCategoryScreen
import com.example.myportfolioadminapp.feature.skill_category.presentation.show_categories.SkillCategoryScreen
import com.example.myportfolioadminapp.feature.skill_category.presentation.update_category.UpdateSkillCategoryScreen
import com.example.myportfolioadminapp.route.SkillCategoryRoute

fun NavGraphBuilder.skillCategoryNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = SkillCategoryRoute.Home.route,
        route = Graph.SKILL_CATEGORY
    ) {

        composable(route = SkillCategoryRoute.Home.route) {
            SkillCategoryScreen(navController)
        }
        composable(route = SkillCategoryRoute.AddCategory.route) {
            AddSkillCategoryScreen(navController)
        }
        composable(route = SkillCategoryRoute.UpdateCategory.route+"/{categoryId}") {
            UpdateSkillCategoryScreen(navController)
        }

    }
}