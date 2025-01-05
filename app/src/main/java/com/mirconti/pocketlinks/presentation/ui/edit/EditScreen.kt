package com.mirconti.pocketlinks.presentation.ui.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
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

    viewModel.linkModel.value?.let {
        val name = remember { mutableStateOf(TextFieldValue(it.name)) }
        val url = remember { mutableStateOf(TextFieldValue(it.url)) }
        val category = remember { mutableStateOf(TextFieldValue("")) }
        val isFavourite = remember { mutableStateOf(false) }

        Column {
            Text(
                text = PocketApplication.getString(if (isnew) R.string.newitem else R.string.edit),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            TextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                label = { Text(text = PocketApplication.getString(R.string.name)) },
                placeholder = { Text(text = "") },
            )
            TextField(
                value = url.value,
                onValueChange = {
                    url.value = it
                },
                label = { Text(text = PocketApplication.getString(R.string.url)) },
                placeholder = { Text(text = "") },
            )
            TextField(
                value = category.value,
                onValueChange = {
                    category.value = it
                },
                label = { Text(text = PocketApplication.getString(R.string.addCategory)) },
                placeholder = { Text(text = "") },
            )

        }
    }




}