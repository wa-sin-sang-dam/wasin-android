package com.wasin.presentation._util

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LaunchedEffectEvent(
    eventFlow: SharedFlow<WasinEvent>,
    onNavigate: () -> Unit = {},
) {
    val context = LocalContext.current
    val canFinish = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when (event) {
                is WasinEvent.Navigate -> onNavigate()
                is WasinEvent.MakeToast -> Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                is WasinEvent.Loading -> { }
            }
        }
    }
    LaunchedEffect(canFinish.value) {
        if (canFinish.value) {
            delay(3000)
            canFinish.value = false
        }
    }
    BackHandler(enabled = true) {
        if (canFinish.value) {
            // 앱 종료
            (context as? Activity)?.finish()
        }
        else {
            Toast.makeText(context, "'뒤로'버튼 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
            canFinish.value = true
        }
    }
}
