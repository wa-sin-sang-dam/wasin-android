package com.wasin.presentation.router_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wasin.presentation._common.CompanyImageItem
import com.wasin.presentation._common.ImageMarker
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation._theme.typography
import com.wasin.presentation.setting.SettingContentTheme
import com.wasin.presentation.setting.WithArrowItem

@Composable
fun RouterDetailScreen(
    navController: NavController
) {
    WithTitle("휴게실 Wifi") {
        item {
            Box (
                modifier = Modifier.fillMaxWidth()
            ) {
                CompanyImageItem()
                ImageMarker(Modifier.offset(90.dp, 10.dp))
            }
        }
        item { RouterState() }
        item { RouterMonitoring() }
        item { SystemRestore() }
        item {
            Editing(
                onUpdateClick = { navController.navigate(WasinScreen.RouterUpdateScreen.route) },
                onDeleteClick = { }
            )
        }
    }
}

@Composable
fun RouterState() {
    SettingContentTheme(
        title = "상태 확인"
    ) {
        RouterStateItem("이름", "휴게실 Wifi")
        RouterStateItem("MAC 주소", "88:22:99:00:02:1A")
        RouterStateItem("상태", "97점")
    }
}

@Composable
fun RouterStateItem(
    title: String = "",
    content: String = "",
) {
    Row {
        Text(
            modifier = Modifier.width(100.dp),
            text = title,
            style = typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
        )
        Text(
            text = content,
            style = typography.bodyLarge,
        )
    }
}

@Composable
fun RouterMonitoring() {
    SettingContentTheme(
        title = "모니터링"
    ) {
        WithArrowItem("공유기 모니터링") {

        }
    }
}

@Composable
fun SystemRestore() {
    SettingContentTheme(
        title = "복구하기"
    ) {
        WithArrowItem("시스템 점검하기") {

        }
        WithArrowItem("로그 파일 이메일 전송하기") {

        }
    }
}

@Composable
fun Editing(onUpdateClick: () -> Unit, onDeleteClick: () -> Unit) {
    SettingContentTheme(
        title = "편집하기",
        isLast = true
    ) {
        WithArrowItem("수정하기", onUpdateClick)
        WithArrowItem("삭제하기", onDeleteClick)
    }
}
