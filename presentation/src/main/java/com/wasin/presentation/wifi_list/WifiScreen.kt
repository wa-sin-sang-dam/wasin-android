package com.wasin.presentation.wifi_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wasin.presentation.R
import com.wasin.presentation._common.GrayDivider
import com.wasin.presentation._common.ShortButton
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._theme.gray_808080
import com.wasin.presentation._theme.gray_C9C9C9
import com.wasin.presentation._theme.main_pink
import com.wasin.presentation._theme.typography

@Composable
fun WifiScreen() {
    WithTitle(
        title = "Wifi 연결",
        description = "자동 또는 수동으로 최적의 와이파이에 연결되도록 설정할 수 있어요.",
        containSetting = true
    ) {
        item { WifiAutoMode() }
        item { GrayDivider() }
        item { WifiListComponent() }
    }
}

@Composable
fun WifiListComponent() {
    Column {
        WifiListTitle()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "정렬 기준",
                style = typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            FilterDropDownButton(
                Modifier.align(Alignment.CenterEnd)
            )
        }
        WifiItemComponent()
        WifiItemComponent()
        WifiItemComponent()
        WifiItemComponent()
        WifiItemComponent()
        WifiItemComponent()
        WifiItemComponent()
        WifiItemComponent()
        WifiItemComponent()
    }
}

@Composable
fun WifiItemComponent(
    name: String = "휴게실 와이파이",
    state: String = "상태: 보통"
) {
    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WifiWithIcon(name, state)
            }
            ShortButton(
                text = "연결",
                isSelected = true,
                onClick = { },
            )
        }
        GrayDivider(modifier = Modifier.padding(top = 17.dp))
    }
}

@Composable
private fun WifiWithIcon(name: String, state: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.wifi),
            tint = main_pink,
            contentDescription = "toggle filtering list",
            modifier = Modifier
                .padding(end = 15.dp)
                .width(30.dp)
        )
        Column {
            Text(
                text = name,
                style = typography.titleMedium,
                modifier = Modifier.padding(bottom = 7.dp)
            )
            Text(
                text = state,
                style = typography.bodyMedium,
                color = gray_808080
            )
        }
    }
}

@Composable
fun FilterDropDownButton(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .border(BorderStroke(1.dp, gray_C9C9C9), RoundedCornerShape(30.dp))
            .padding(vertical = 5.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            tint = gray_C9C9C9,
            contentDescription = "toggle filtering list",
            modifier = Modifier.width(30.dp)
        )
        Text(
            text = "추천순",
            style = typography.bodyMedium,
            color = gray_C9C9C9,
        )
    }
}

@Composable
private fun WifiListTitle() {
    Text(
        text = "Wifi 목록",
        style = typography.titleMedium,
        modifier = Modifier.padding(bottom = 13.dp)
    )
    Text(
        text = "네트워크 품질을 확인할 수 있는 Wifi는 파란색으로, 정확히 알 수 없는 Wifi는 분홍색으로 표시돼요.",
        style = typography.bodyMedium
    )
}

@Composable
fun WifiAutoMode() {
    Column {
        Text(
            text = "모드",
            style = typography.titleMedium,
            modifier = Modifier.padding(bottom = 13.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ShortButton(
                text = "자동",
                onClick = { /*TODO*/ },
                isSelected = false
            )
            ShortButton(
                text = "수동",
                onClick = { /*TODO*/ },
                isSelected = true
            )
        }
    }
}
