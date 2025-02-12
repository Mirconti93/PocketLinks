package com.mirconti.pocketlinks.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mircontapp.sportalbum.domain.models.LinkModel
import com.mircontapp.sportalbum.presentation.ui.theme.OrangeYellowD
import com.mircontapp.sportalbum.presentation.viewmodels.MainViewModel
import com.mirconti.pocketlinks.PocketApplication
import com.mirconti.pocketlinks.R

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: HomeViewModel = hiltViewModel()

    LaunchedEffect((Unit), block = {
        viewModel.onAction(HomeAction.Load)
    })
    Column {
        Text(
            text = PocketApplication.instance.getString(R.string.app_name),
            textAlign = TextAlign.Center,
            color = Color.White
        )

        val state = viewModel.state.collectAsState()

        when {
            state.value.links.isNotEmpty() -> Text(modifier = Modifier, text = PocketApplication.getString(R.string.noitems), fontSize = 14.sp, textAlign = TextAlign.Center,)
            else -> {
                LazyColumn {
                    viewModel.state.value.links.forEach{link->
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                ),
                                shape = RoundedCornerShape(4.dp),
                                ) {
                                Column(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(modifier = Modifier, text = link.name, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                }
                            }
                        }
                    }
                }
            }
        }



    }
}

@Composable
fun LinkItem(linkModel: LinkModel) {
    Card(
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        shape = RoundedCornerShape(4.dp)

    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.padding(2.dp)) {
                Text(modifier = Modifier.weight(1f), text = linkModel.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(modifier = Modifier, text = linkModel.url, color = OrangeYellowD, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }

    }
}
