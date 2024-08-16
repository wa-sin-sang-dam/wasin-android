package com.wasin.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wasin.presentation.R
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.TextField
import com.wasin.presentation._common.WhiteLongButton
import com.wasin.presentation._navigate.WasinScreen

@Composable
fun LoginScreen(
    navController: NavController,
    onNavigate: () -> Unit = {}
) {
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { WasinLogo() }
        item { LoginTextField() }
        item { LoginButton(onNavigate) }
        item { SignupButton{ navController.navigate(WasinScreen.SignupScreen.route) } }
    }
}

@Composable
fun WasinLogo() {
    Image(
        painter = painterResource(id = R.drawable.wasin_logo),
        contentDescription = "wasin_logo",
        modifier = Modifier.height(200.dp)
    )
}

@Composable
fun LoginTextField() {
    Column(
        modifier = Modifier.padding(top = 65.dp, bottom = 53.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 14.dp),
            text = "",
            placeholder = "아이디(이메일)",
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            text = "",
            placeholder = "비밀번호",
        )
    }
}

@Composable
fun LoginButton(
    onClick: () -> Unit
) {
    BlueLongButton(
        text = "로그인",
        onClick = onClick,
        modifier = Modifier.padding(bottom = 14.dp)
    )
}

@Composable
fun SignupButton(
    onClick: () -> Unit
) {
    WhiteLongButton(
        text = "회원가입",
        onClick = onClick
    )
}
