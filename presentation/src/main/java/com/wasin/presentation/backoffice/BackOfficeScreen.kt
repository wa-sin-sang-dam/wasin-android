package com.wasin.presentation.backoffice

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wasin.presentation._common.ShortButton
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._theme.gray_E8E8E8
import com.wasin.presentation._theme.typography

@Composable
fun BackOfficeScreen() {
    val nameList = listOf("남원정", "권내현", "장원석", "남원정", "권내현", "장원석")
    WithTitle(
        title = "관리자 승인 대기"
    ) {
        items(nameList) { WaitingItem(it) }
    }
}

@Composable
fun WaitingItem(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(BorderStroke(0.5.dp, gray_E8E8E8), RoundedCornerShape(30.dp))
            .padding(horizontal = 20.dp, vertical = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = name,
            style = typography.titleMedium,
        )
        ShortButton(
            modifier = Modifier.align(Alignment.CenterEnd),
            text = "승인",
            isSelected = true,
            onClick = {}
        )
    }
}
