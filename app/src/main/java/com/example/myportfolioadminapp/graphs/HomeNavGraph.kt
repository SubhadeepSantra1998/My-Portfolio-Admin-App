package com.example.myportfolioadminapp.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myportfolioadminapp.feature.my_education.presentation.my_education.MyEducationScreen
import com.example.myportfolioadminapp.feature.home.model.HomeBottomBarItem
import com.example.myportfolioadminapp.feature.personal_info.presentation.PersonalInfoScreen
import com.example.myportfolioadminapp.feature.my_skill.presentation.my_skills.MySkillsScreen


@Composable
fun HomeNavGraph(
    navController: NavHostController,
    paddingValue: PaddingValues,
) {


    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarItem.PersonalInfo.route,
    ) {
        composable(route = HomeBottomBarItem.PersonalInfo.route) {
            PersonalInfoScreen(navController, paddingValue)
        }

        composable(HomeBottomBarItem.Education.route) {
            MyEducationScreen(navController, paddingValue)
        }

        composable(route = HomeBottomBarItem.Skill.route) {
            MySkillsScreen(navController, paddingValue)
        }

        // skill graph
        skillNavGraph(navController = navController)

        educationNavGraph(navController, paddingValue)


        //category graph from drawer menu
        educationCategoryNavGraph(navController = navController)
        skillCategoryNavGraph(navController = navController)




    }
}
