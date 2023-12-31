package com.example.npsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.npsapp.ui.navigation.SetUpNavGraph
import com.example.npsapp.ui.theme.NPSAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NPSAppTheme {
                val navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}