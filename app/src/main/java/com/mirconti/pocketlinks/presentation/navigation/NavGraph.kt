package com.mircontapp.sportalbum.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mirconti.pocketlinks.presentation.navigation.Routes
import com.mirconti.pocketlinks.presentation.ui.edit.EditScreen
import com.mirconti.pocketlinks.presentation.ui.home.HomeScreen

@ExperimentalMaterial3Api
@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home)
    {
        composable<Routes.Home> {
            HomeScreen(navController = navController)
        }
        composable<Routes.Edit>{
            EditScreen(navController = navController)
        }
    }
}
