package com.wasin.presentation.lock_confirm

import androidx.compose.runtime.Composable
import com.wasin.presentation._common.LockComponent
import com.wasin.presentation._common.WithTitle

@Composable
fun LockConfirmScreen() {
    WithTitle(
        title = "잠금 해제 비밀번호 입력",
        description = "높은 보안성을 유지하기 위해 잠금 해제시 사용할 비밀번호를 입력해주세요."
    ) {
        item { LockComponent() }
    }
}
