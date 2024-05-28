package com.mirconti.pocketlinks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mircontapp.sportalbum.presentation.navigation.NavGraph
import com.mircontapp.sportalbum.presentation.navigation.NavigationItem
import com.mircontapp.sportalbum.presentation.ui.theme.PocketTheme
import com.mircontapp.sportalbum.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel: MainViewModel by viewModels()

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            PocketTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = {
                        BottomBarNavigation(navController, arrayListOf(
                            NavigationItem.Home,
                            NavigationItem.Edit
                        ))
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        NavGraph(navController = navController, mainViewModel = mainViewModel)
                    }
                }
            }
        }
    }

    @Composable
    fun BottomBarNavigation(navController: NavController, items: List<NavigationItem>) {
        Box (
            Modifier.background(MaterialTheme.colorScheme.primary)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                items.forEach {
                    IconButton(onClick = {
                        navController.navigate(it.route)
                    }) {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = null
                        )
                    }
                }

            }
        }

    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BottomBarNavigation(navController = rememberNavController(), arrayListOf(
            NavigationItem.Home,
            NavigationItem.Edit,
        ))
    }
}

