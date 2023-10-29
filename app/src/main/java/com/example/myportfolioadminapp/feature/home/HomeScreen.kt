package com.example.myportfolioadminapp.feature.home

import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myportfolioadminapp.common.util.controller.SnackbarController
import com.example.myportfolioadminapp.graphs.HomeNavGraph
import com.example.myportfolioadminapp.feature.home.presentation.component.BottomBarComponent


@Composable
fun HomeScreen(
    snackbarController: SnackbarController,
    navController: NavHostController = rememberNavController()
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        bottomBar = { BottomBarComponent(navController) },
        snackbarHost = {}
    ) { paddingValue ->
        HomeNavGraph(navController = navController, paddingValue)
    }
}
