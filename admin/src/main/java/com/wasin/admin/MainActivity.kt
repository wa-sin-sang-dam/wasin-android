package com.wasin.admin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wasin.admin.navigate.adminNavGraph
import com.wasin.presentation._navigate.BottomNavItem
import com.wasin.presentation._navigate.BottomNavigationBar
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation._navigate.commonAdminNavGraph
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
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController,
                        screens = listOf(BottomNavItem.Monitoring, BottomNavItem.Router,
                            BottomNavItem.Profile, BottomNavItem.Setting)
                    )
                },
                content = {
                    NavHost(
                        navController = navController,
                        startDestination = WasinScreen.SplashScreen.route,
                        route = "wasin_admin_route"
                    ){
                        commonNavGraph(navController = navController)
                        commonAdminNavGraph(navController = navController)
                        adminNavGraph(navController = navController)
                    }
                }
            )
        }
    }
}
