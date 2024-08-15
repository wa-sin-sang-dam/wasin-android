package com.wasin.presentation.router_update

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.TextFieldWithTitle
import com.wasin.presentation._common.WhiteLongButton
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation.router_add.RouterPositionInImage

@Composable
fun RouterUpdateScreen() {
    WithTitle("라우터 수정") {
        item {
            TextFieldWithTitle(
                title = "이름(별칭)",
                placeholder = "휴게실 Wifi"
            )
        }
        item { RouterPositionInImage() }
        item {
            BlueLongButton(text = "수정하기")
            Spacer(modifier = Modifier.height(10.dp))
            WhiteLongButton(text = "삭제하기")
        }
    }
}
