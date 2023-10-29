package com.example.myportfolioadminapp.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.myportfolioadminapp.feature.education_category.presentation.add_category.AddEducationCategoryScreen
import com.example.myportfolioadminapp.feature.education_category.presentation.show_categories.EducationCategoryScreen
import com.example.myportfolioadminapp.feature.education_category.presentation.update_category.UpdateEducationCategoryScreen
import com.example.myportfolioadminapp.route.EducationCategoryRoute

fun NavGraphBuilder.educationCategoryNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = EducationCategoryRoute.Home.route,
        route = Graph.EDUCATION_CATEGORY
    ) {

        composable(route = EducationCategoryRoute.Home.route) {
            EducationCategoryScreen(navController)
        }
        composable(route = EducationCategoryRoute.AddCategory.route) {
            AddEducationCategoryScreen(navController)
        }
        composable(route = EducationCategoryRoute.UpdateCategory.route+"/{categoryId}") {
            UpdateEducationCategoryScreen(navController)
        }

    }
}