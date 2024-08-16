package com.wasin.admin.navigate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation.company_admin.CompanyAdminScreen
import com.wasin.presentation.lock_confirm.LockConfirmScreen
import com.wasin.presentation.lock_setting.LockSettingScreen

fun NavGraphBuilder.adminNavGraph(
    navController: NavController
) {
    composable(
        route = WasinScreen.CompanyAdminScreen.route,
        content = { CompanyAdminScreen(navController) }
    )
    composable(
        route = WasinScreen.LockConfirmScreen.route,
        content = {
            LockConfirmScreen(
                navController = navController,
                onNavigate = { navController.navigate(WasinScreen.MonitoringScreen.route) }
            )
        }
    )
    composable(
        route = WasinScreen.LockSettingScreen.route,
        content = {
            LockSettingScreen(
                navController = navController,
                onNavigate = { navController.navigate(WasinScreen.MonitoringScreen.route) }
            )
        }
    )
}
