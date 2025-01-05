package com.mircontapp.sportalbum.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.mirconti.pocketlinks.presentation.navigation.Routes

sealed class NavigationItem<T>(var route: T, var icon: ImageVector, var title: String) {
    object Home : NavigationItem<Routes.Home>(Routes.Home, Icons.Default.Home, "Home")
    object Edit : NavigationItem<Routes.Edit>(Routes.Edit(null), Icons.Default.Favorite, "Edit")
}
