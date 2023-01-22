package com.example.cinapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigation(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Movie : BottomNavigation(
        route = "movie",
        //icon = R.drawable.ic_baseline_movie_24,
        icon = Icons.Filled.Movie,
        title = "Movie")
    object Search : BottomNavigation(
        route = "search",
        //icon = R.drawable.ic_baseline_search_24,
        icon = Icons.Filled.Search,
        title = "Search")
    object Serie : BottomNavigation(
        route = "serie",
        //icon = R.drawable.ic_baseline_live_tv_24,
        icon = Icons.Filled.LiveTv,
        title = "Serie")
}
