package com.example.npsapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.npsapp.R
import com.example.npsapp.ui.navigation.Screens
import com.example.npsapp.ui.theme.lemonFontFamily
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true){
        delay(2500)
        navController.navigate(Screens.SelectionScreen.route){
            popUpTo(navController.graph.findStartDestination().id){
                inclusive = true }}
    }

    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxWidth()
            .fillMaxHeight()
            .paint(
                painter = painterResource(R.drawable.glacier_natl),
                contentScale = ContentScale.FillHeight,
            )

    ) {
        Text(
            text = stringResource(R.string.title),
            fontSize = 48.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontFamily = lemonFontFamily,
            lineHeight = 50.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(30.dp)
        )
    }
}

