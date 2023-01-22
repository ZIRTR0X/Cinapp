package com.example.cinapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavigation.Movie.route
    ) {
        composable(BottomNavigation.Movie.route) {
            MovieScreen()
        }
        composable(BottomNavigation.Search.route) {
            SearchScreen()
        }
        composable(BottomNavigation.Serie.route) {
            SerieScreen()
        }
    }
}