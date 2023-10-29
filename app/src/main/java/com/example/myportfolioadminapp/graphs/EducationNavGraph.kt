package com.example.myportfolioadminapp.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.myportfolioadminapp.feature.my_education.presentation.add_education.AddMyEducationScreen
import com.example.myportfolioadminapp.feature.my_education.presentation.my_education.MyEducationScreen
import com.example.myportfolioadminapp.route.MyEducationRoute


fun NavGraphBuilder.educationNavGraph(
    navController: NavHostController,
    paddingValue: PaddingValues,
) {
    navigation(
        startDestination = MyEducationRoute.Education.route,
        route = Graph.MY_EDUCATION
    ) {

        composable(route = MyEducationRoute.Education.route) {
            MyEducationScreen(navController, paddingValue)
        }
        composable(route = MyEducationRoute.AddEducation.route) {
            AddMyEducationScreen(navController, paddingValue)
        }
//        composable(route = EducationCategoryRoute.UpdateCategory.route+"/{categoryId}") {
//            UpdateEducationCategoryScreen(navController)
//        }

    }
}