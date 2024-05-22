package com.mircontapp.sportalbum.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mircontapp.sportalbum.presentation.viewmodels.MainViewModel
import com.mirconti.pocketlinks.presentation.ui.home.HomeScreen

@ExperimentalMaterial3Api
@Composable
fun NavGraph(navController: NavHostController, mainViewModel: MainViewModel){
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Album.route)
    {
        composable(route = NavigationItem.Album.route){
            HomeScreen(navController = navController, mainViewModel)
        }
    }
}
