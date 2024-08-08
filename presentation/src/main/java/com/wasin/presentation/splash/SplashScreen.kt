package com.wasin.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wasin.presentation.R

@Composable
fun SplashScreen() {
    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.wasin_logo),
            contentDescription = "wasin_logo",
            modifier = Modifier
                .height(200.dp)
                .align(Alignment.Center)
        )
    }
}
