package com.wasin.presentation.company_admin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._navigate.WasinScreen
import com.wasin.presentation._theme.gray_808080
import com.wasin.presentation._theme.gray_979797
import com.wasin.presentation._theme.main_blue
import com.wasin.presentation._theme.typography

@Composable
fun CompanyAdminScreen(navController: NavController) {
    WithTitle(
        title = "회사 등록"
    ) {
        item { CompanyAdminItemComponent(true) }
        item { CompanyAdminItemComponent(false) }
        item { CompanyAdminItemComponent(false) }
        item { CompanyAdminItemComponent(false) }
        item { CompanyAdminItemComponent(false) }
        item { CompanyAdminItemComponent(false) }
        item {
            Spacer(modifier = Modifier.height(30.dp))
            BlueLongButton(
                text = "등록 완료",
                onClick = { navController.navigate(WasinScreen.LockSettingScreen.route) }
            )
        }
    }
}

@Composable
fun CompanyAdminItemComponent(
    isSelected: Boolean,
    onClick: () -> Unit = {},
) {
    Row {
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = main_blue,
                unselectedColor = gray_979797
            )
        )
        Column {
            Text(
                text = "한국은행",
                style = typography.bodyLarge
            )
            Text(
                text = "부산광역시 수영구 광안해변로 418",
                style = typography.bodySmall,
                color = gray_808080,
                modifier = Modifier.padding(top = 7.dp, bottom = 10.dp)
            )
        }
    }


}
