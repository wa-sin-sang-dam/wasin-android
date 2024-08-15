package com.wasin.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.wasin.presentation._common.addFocusCleaner
import com.wasin.presentation._theme.Dimens
import com.wasin.presentation._theme.WasinTheme
import com.wasin.presentation.profile.ProfileScreen

@Preview
@Composable
fun preview() {
    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier.background(Color.White)
            .padding(Dimens.ScreenPadding)
            .fillMaxSize()
            .addFocusCleaner(focusManager)
    ) {
        WasinTheme {
            ProfileScreen()
        }
        it
    }
}
