package com.wasin.admin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wasin.admin.navigate.adminNavGraph
import com.wasin.presentation._navigate.BottomNavItem
import com.wasin.presentation._navigate.BottomNavigationBar
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation._navigate.commonAdminNavGraph
import com.wasin.presentation._navigate.commonNavGraph
import com.wasin.presentation._theme.WasinAppTheme
import com.wasin.presentation._util.startScreenData
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            openRouterDetail(navController)
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

    override fun onRestart() {
        super.onRestart()
        if (startScreenData(applicationContext)) {
            navController.navigate(WasinScreen.LockConfirmScreen.route)
        }
    }

    private fun openRouterDetail(navController: NavController) {
        try {
            if (intent?.extras != null) {
                val routerId = intent.extras!!.get("routerId").toString().toIntOrNull()
                if (routerId != null) {
                    navController.navigate(WasinScreen.RouterDetailScreen.route + "?routerId=$routerId")
                }
            }
        } catch(_: Exception){ }
    }



}
