package com.example.myportfolioadminapp.graphs

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myportfolioadminapp.common.util.controller.SnackbarController
import com.example.myportfolioadminapp.feature.home.HomeScreen


@Composable
fun RootNavGraph(
    navController: NavHostController,
    snackbarController: SnackbarController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.HOME
    ) {

        // onboarding screen
        //onBoardingNavGraph(navController = navController)


        //authNavGraph(navController = navController)

        composable(route = Graph.HOME) {
            HomeScreen(snackbarController)
        }
    }
}