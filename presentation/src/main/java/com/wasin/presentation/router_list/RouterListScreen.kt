package com.wasin.presentation.router_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.CompanyImageItem
import com.wasin.presentation._common.ImageMarker
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._theme.gray_E8E8E8
import com.wasin.presentation._theme.main_green
import com.wasin.presentation._theme.typography

@Composable
fun RouterListScreen() {
    WithTitle(
        title = "라우터 관리",
        description = "라우터 상태에 따라 원활할 경우 초록색, 불안정할 경우 빨간색으로 나타나요. \n" +
                "마커를 클릭하면 개별 라우터에 대한 상세 정보를 확인 및 편집하고 모니터링을 진행할 수 있어요."
    ) {
        item {
            Box (
                modifier = Modifier.fillMaxWidth()
            ) {
                CompanyImageItem()
                ImageMarker(Modifier.offset(90.dp, 10.dp))
                ImageMarker(Modifier.offset(20.dp, 100.dp))
            }
        }
        item {
            BlueLongButton(
                text = "라우터 추가",
                onClick = { }
            )
        }
        item {
            Text(
                text = "Wifi 목록",
                style = typography.titleMedium,
                modifier = Modifier.padding(top = 25.dp)
             )
        }
        item { RouterItemComponent() }
        item { RouterItemComponent() }
        item { RouterItemComponent() }
        item { RouterItemComponent() }
    }
}

@Composable
fun RouterItemComponent(
    name: String = "휴게소 Wifi ",
    score: Int = 89
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .border(BorderStroke(0.5.dp, gray_E8E8E8), RoundedCornerShape(30.dp))
            .padding(horizontal = 30.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = name,
            style = typography.titleMedium,
        )
        Text(
            text = "$score 점",
            style = typography.titleMedium,
            color = main_green
        )
    }
}
