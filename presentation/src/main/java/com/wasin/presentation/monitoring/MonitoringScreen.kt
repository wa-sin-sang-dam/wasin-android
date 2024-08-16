package com.wasin.presentation.monitoring

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController


@Composable
fun MonitoringScreen(navController: NavController) {
    val url = "http://grafana.daily-cotidie.com/"
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW)

    intent.data = Uri.parse(url)
    intent.setPackage("com.android.chrome")

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}
