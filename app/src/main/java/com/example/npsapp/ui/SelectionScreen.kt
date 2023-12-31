package com.example.npsapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.example.npsapp.R
import com.example.npsapp.ui.components.SelectionButton
import com.example.npsapp.ui.components.dropDownMenu
import com.example.npsapp.ui.navigation.Screens
import com.example.npsapp.ui.theme.lemonFontFamily
import com.example.npsapp.util.Constants

@Composable
fun SelectionScreen(navController: NavHostController){
    var stateName: String
    var activityName: String
    Column{
        Box(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth()
                .paint(
                    painter = painterResource(R.drawable.zion_natl),
                    contentScale = ContentScale.FillWidth
                )
        )
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Column (modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = stringResource(R.string.homescreen_first),
                    fontSize =28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontFamily = lemonFontFamily,
                    modifier = Modifier
                        .padding(16.dp))
                activityName = dropDownMenu(Constants.activityMap.keys.toList())
                Text(text = stringResource(R.string.homescreen_second),
                    fontSize =28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontFamily = lemonFontFamily,
                    modifier = Modifier
                        .padding(10.dp))
                stateName = dropDownMenu(Constants.statesMap.keys.toList())
                Column (modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    if (stateName.isNotBlank() && activityName.isNotBlank()) {
                        SelectionButton(
                            onClick = {
                                navController.navigate(
                                    route = Screens.ListScreen.getFullRoute(
                                        name = stateName, activity = activityName
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
