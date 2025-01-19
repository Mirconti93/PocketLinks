package com.mirconti.pocketlinks.presentation.ui.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.gson.Gson
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mirconti.pocketlinks.PocketApplication
import com.mirconti.pocketlinks.R
import com.mirconti.pocketlinks.presentation.ui.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(navController: NavController, linkArg: String) {

    val isnew = remember { true }
    val viewModel: EditViewModel = hiltViewModel()

    Gson().fromJson(linkArg, LinkModel::class.java)?.let {
        LaunchedEffect((Unit), block = {
            viewModel.onAction(EditAction.Init(it))
        })
    }

    viewModel.state.collectAsState().value.linkModel.let {
        val name = remember { mutableStateOf(TextFieldValue(it?.name ?: "")) }
        val url = remember { mutableStateOf(TextFieldValue(it?.url ?: "")) }
        val category = remember { mutableStateOf(it?.categories?: emptyList()) }
        val isFavourite = remember { mutableStateOf(it?.favourite ?: false) }

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


        }
    }




}