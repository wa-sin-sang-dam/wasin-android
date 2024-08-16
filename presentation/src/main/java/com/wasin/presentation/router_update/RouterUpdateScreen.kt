package com.wasin.presentation.router_update

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.TextFieldWithTitle
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation.router_add.RouterPositionInImage

@Composable
fun RouterUpdateScreen(navController: NavController) {
    WithTitle("라우터 수정") {
        item {
            TextFieldWithTitle(
                title = "이름(별칭)",
                placeholder = "휴게실 Wifi"
            )
        }
        item { RouterPositionInImage() }
        item {
            BlueLongButton(text = "수정하기") {
                navController.navigate(WasinScreen.RouterListScreen.route)
            }
        }
    }
}
