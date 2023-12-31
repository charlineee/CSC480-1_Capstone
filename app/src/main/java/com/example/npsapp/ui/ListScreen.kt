package com.example.npsapp.ui

import com.example.npsapp.viewmodels.ListViewModel

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.npsapp.R
import com.example.npsapp.models.Images
import com.example.npsapp.ui.theme.lemonFontFamily
import com.example.npsapp.viewmodels.ParksUIState
import com.example.npsapp.viewmodels.ParksViewState

@Composable
fun ListScreen(
    name: String,
    activity: String,
    listViewModel: ListViewModel
) {

    val viewState by listViewModel.uiState.collectAsState()

    LaunchedEffect(Unit){
        listViewModel.getCodes(name, activity)
    }
    Column {
        Header(activity = activity, name = name )
        when (val uiState = viewState) {
            is ParksUIState.Error -> Error()
            is ParksUIState.Loading -> Loading()
            is ParksUIState.Success -> {
                uiState.data?.let { park ->
                    if (park.isEmpty()) {
                        EmptyScreen()
                    } else {
                        ParksList(parks = park)
                    }
                }
            }
        }
    }
}

@Composable
fun ParksList(
    parks: List<ParksViewState>
) {
    LazyColumn {
        items(count = parks.size, itemContent = { index ->
            ParksView(
                parks = parks[index],
                image = parks[index].images[0]
            )}
        )
    }
}


@Composable
fun EmptyScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.joshua_natl),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier.padding(8.dp)
        ){
            Column{
                Text(text = "It's looking lonely out here.",
                    fontFamily = lemonFontFamily,
                    fontSize = 24.sp,
                    color = Color.Black)
                Text(text = "No parks found. Try again?",
                    fontFamily = lemonFontFamily,
                    fontSize = 16.sp,
                    color = Color.Black)
            }
        }
    }
}

@Composable
fun ParksView(
    parks: ParksViewState,
    image: Images
) {
    var expanded by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f, label = ""
    )
    Column {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clickable(onClick = { expanded = !expanded })
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = Color.DarkGray)
            ) {
                Text(
                    text = parks.name.toString(),
                    color = Color.White,
                    fontFamily = lemonFontFamily,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(1F)
                        .padding(8.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                IconButton(
                    modifier = Modifier
                        .alpha(.2F)
                        .rotate(rotationState),
                    onClick = {
                        expanded = !expanded
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow",
                        tint = Color.White
                    )
                }
            }
            if (expanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Box(
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth()
                    ) {
                        AsyncImage(
                            model = image.url,
                            contentDescription = image.altText,
                            contentScale = ContentScale.Crop,
                            alpha = .9F
                        )
                    }
                    Text(
                        text = parks.description.toString(),
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Header(activity: String, name: String){
    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ){
        Text(
            text = "Results for $activity in $name",
            fontFamily = lemonFontFamily,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}