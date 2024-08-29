package com.wasin.presentation.lock_confirm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wasin.presentation._common.LockComponent
import com.wasin.presentation._theme.typography
import com.wasin.presentation._util.LaunchedEffectEvent
import com.wasin.presentation._util.WasinBackHandler

@Composable
fun LockConfirmScreen(
    navController: NavController,
    nextScreen: String,
    viewModel: LockConfirmViewModel = hiltViewModel()
) {
    WasinBackHandler()
    LaunchedEffectEvent(
        eventFlow = viewModel.eventFlow,
        onNavigate = {
            viewModel.saveScreenState(nextScreen)
            navController.navigate(nextScreen){
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        }
    )
    Column(
        modifier = Modifier.padding(top = 90.dp),
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
        LockComponent(
            password = viewModel.lockDTO.value,
            onAdd = { viewModel.addPassword(it) },
            onDelete = { viewModel.removeLast() },
        )
    }
}
