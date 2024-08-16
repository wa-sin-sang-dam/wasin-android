package com.wasin.presentation.lock_setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wasin.presentation._common.LockComponent
import com.wasin.presentation._theme.typography

@Composable
fun LockSettingScreen(
    navController: NavController,
    onNavigate: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "잠금해제",
            style = typography.titleLarge,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Text(
            text = "비밀번호를 입력해주세요.",
            style = typography.bodyMedium
        )
        LockComponent()
    }
}
