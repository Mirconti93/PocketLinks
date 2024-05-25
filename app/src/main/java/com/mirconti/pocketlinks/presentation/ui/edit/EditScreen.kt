package com.mirconti.pocketlinks.presentation.ui.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mirconti.pocketlinks.PocketApplication
import com.mirconti.pocketlinks.R
import com.mirconti.pocketlinks.presentation.ui.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(navController: NavController) {

    val isnew = remember { true }
    val viewModel: EditViewModel = hiltViewModel()

    Column {
        Text(
            text = PocketApplication.instance.getString(if (isnew) R.string.newitem else R.string.edit),
            textAlign = TextAlign.Center,
            color = Color.White
        )
        TextField(
            value = viewModel.linkModel.value?.name ?: "",
            onValueChange = {

            },
            label = { Text(text = "Your Label") },
            placeholder = { Text(text = "Your Placeholder/Hint") },
        )
    }
}