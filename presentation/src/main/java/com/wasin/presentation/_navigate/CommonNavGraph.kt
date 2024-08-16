package com.wasin.presentation._navigate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wasin.presentation.login.LoginScreen
import com.wasin.presentation.monitoring.MonitoringScreen
import com.wasin.presentation.profile.ProfileScreen
import com.wasin.presentation.router_add.RouterAddScreen
import com.wasin.presentation.router_detail.RouterDetailScreen
import com.wasin.presentation.router_list.RouterListScreen
import com.wasin.presentation.router_update.RouterUpdateScreen
import com.wasin.presentation.setting.SettingScreen
import com.wasin.presentation.signup.SignupScreen
import com.wasin.presentation.splash.SplashScreen

fun NavGraphBuilder.commonNavGraph(
    navController: NavController
) {
    composable(
        route = WasinScreen.SplashScreen.route,
        content = { SplashScreen(navController) }
    )
    composable(
        route = WasinScreen.SignupScreen.route,
        content = { SignupScreen(navController) }
    )
    composable(
        route = WasinScreen.SettingScreen.route,
        content = { SettingScreen(navController) }
    )
}

fun NavGraphBuilder.commonAdminNavGraph(
    navController: NavController
) {
    composable(
        route = WasinScreen.MonitoringScreen.route,
        content = { MonitoringScreen(navController) }
    )
    composable(
        route = WasinScreen.ProfileScreen.route,
        content = { ProfileScreen(navController) }
    )
    composable(
        route = WasinScreen.RouterAddScreen.route,
        content = { RouterAddScreen(navController) }
    )
    composable(
        route = WasinScreen.RouterListScreen.route,
        content = { RouterListScreen(navController) }
    )
    composable(
        route = WasinScreen.RouterDetailScreen.route + "?routerId={routerId}",
        arguments = listOf(
            navArgument("routerId"){
                type = NavType.LongType
                defaultValue = -1L
            },
        ),
        content = { RouterDetailScreen(navController) }
    )
    composable(
        route = WasinScreen.RouterUpdateScreen.route + "?routerId={routerId}",
        arguments = listOf(
            navArgument("routerId"){
                type = NavType.LongType
                defaultValue = -1L
            },
        ),
        content = { RouterUpdateScreen(navController) }
    )
    composable(
        route = WasinScreen.LoginScreen.route,
        content = {
            LoginScreen(navController) {
                navController.navigate(WasinScreen.CompanyAdminScreen.route)
            }
        }
    )
}
