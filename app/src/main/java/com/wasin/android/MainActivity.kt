package com.wasin.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wasin.android.navigate.userNavGraph
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation._navigate.commonNavGraph
import com.wasin.presentation._theme.WasinAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WasinAppTheme(
                bottomBar = {},
                content = {
                    NavHost(
                        navController = navController,
                        startDestination = WasinScreen.SplashScreen.route,
                        route = "wasin_user_route"
                    ){
                        commonNavGraph(navController = navController)
                        userNavGraph(navController = navController)
                    }
                }
            )
        }
    }
}
