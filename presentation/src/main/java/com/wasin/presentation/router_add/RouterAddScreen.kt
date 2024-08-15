package com.wasin.presentation.router_add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.CompanyImageItem
import com.wasin.presentation._common.ImageMarker
import com.wasin.presentation._common.TextFieldWithTitle
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._theme.gray_808080
import com.wasin.presentation._theme.typography

@Composable
fun RouterAddScreen() {
    WithTitle("라우터 추가") {
        item {
            TextFieldWithTitle(
                title = "이름(별칭)",
                placeholder = "휴게실 Wifi"
            )
        }
        item {
            TextFieldWithTitle(
                title = "MAC 주소",
                placeholder = "58:86:94:7f:b4:c4"
            )
        }
        item { RouterPositionInImage() }
        item { BlueLongButton(text = "등록하기") }
    }
}

@Composable
fun RouterPositionInImage() {
    val xPosition = remember { mutableStateOf(90) }
    val yPosition = remember { mutableStateOf(10) }

    Column {
        Text(
            text = "위치",
            style = typography.titleMedium,
            modifier = Modifier.padding(bottom = 11.dp)
        )
        Text(
            text = "라우터가 설치된 위치를 클릭해주세요.",
            style = typography.bodyLarge,
            modifier = Modifier.padding(bottom = 11.dp),
            color = gray_808080
        )
        Box (
            modifier = Modifier.fillMaxWidth()
        ) {
            CompanyImageItem(colorFilter = null)
            ImageMarker(Modifier.offset(xPosition.value.dp, yPosition.value.dp))
        }
    }
}
