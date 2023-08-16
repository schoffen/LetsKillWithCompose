package com.example.letskillwithcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.letskillwithcompose.ui.screens.DetailScreen
import com.example.letskillwithcompose.ui.screens.HomeScreen
import com.example.letskillwithcompose.ui.screens.Screen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navHostController)
        }

        composable(
            route = Screen.Detail.route
        ) {
            DetailScreen(navHostController)
        }
    }
}