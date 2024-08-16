package com.wasin.super_admin.navigate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation.backoffice.BackOfficeScreen
import com.wasin.presentation.company_super_admin.CompanySuperAdminScreen
import com.wasin.presentation.lock_confirm.LockConfirmScreen
import com.wasin.presentation.lock_setting.LockSettingScreen

fun NavGraphBuilder.superAdminNavGraph(
    navController: NavController
) {
    composable(
        route = WasinScreen.BackOfficeScreen.route,
        content = { BackOfficeScreen(navController) }
    )
    composable(
        route = WasinScreen.CompanySuperAdminScreen.route,
        content = { CompanySuperAdminScreen(navController) }
    )
    composable(
        route = WasinScreen.LockConfirmScreen.route,
        content = {
            LockConfirmScreen(
                navController = navController,
                onNavigate = { navController.navigate(WasinScreen.BackOfficeScreen.route) }
            )
        }
    )
    composable(
        route = WasinScreen.LockSettingScreen.route,
        content = {
            LockSettingScreen(
                navController = navController,
                onNavigate = { navController.navigate(WasinScreen.BackOfficeScreen.route) }
            )
        }
    )
}
