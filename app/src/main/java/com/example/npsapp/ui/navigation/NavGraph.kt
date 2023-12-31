package com.example.npsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.npsapp.ui.ListScreen
import com.example.npsapp.ui.SelectionScreen
import com.example.npsapp.ui.SplashScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ){
        composable(
            route = Screens.SplashScreen.route
        ){
            SplashScreen(navController)
        }
        composable(route = Screens.SelectionScreen.route
        ){
            SelectionScreen(navController)
        }
        composable(
            route = Screens.ListScreen.route,
            arguments = listOf(
                navArgument(name = "stateName"){
                    type = NavType.StringType
                },
                navArgument(name = "activityName") {
                    type = NavType.StringType
                }
            )) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("stateName")
            val activity = navBackStackEntry.arguments?.getString("activityName")
            ListScreen(
                name = name!!,
                activity = activity!!,
                listViewModel = hiltViewModel()
            )
        }
    }
}

const val STATE_NAME = "stateName"
const val ACTIVITY_NAME = "activityName"

sealed class Screens(val route: String) {
    object SplashScreen: Screens(route = "splash_screen")
    object SelectionScreen: Screens(route = "selection_screen")
    object ListScreen: Screens(route = "list_screen/{$STATE_NAME}/{$ACTIVITY_NAME}") {
        fun getFullRoute(name: String, activity: String): String {
            return "list_screen/$name/$activity"
        }
    }
}