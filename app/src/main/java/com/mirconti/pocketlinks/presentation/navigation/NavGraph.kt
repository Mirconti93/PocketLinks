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
        startDestination = NavigationItem.Home.route)
    {
        composable(route = NavigationItem.Home.route){
            HomeScreen(navController = navController, mainViewModel)
        }
        composable(route = NavigationItem.Edit.route){
            HomeScreen(navController = navController, mainViewModel)
        }
    }
}
