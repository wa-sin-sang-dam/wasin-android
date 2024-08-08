package com.wasin.presentation.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.wasin.presentation._common.BlueLongButton
import com.wasin.presentation._common.DefaultButton
import com.wasin.presentation._common.GrayLongButton
import com.wasin.presentation._common.TextField
import com.wasin.presentation._common.TextFieldWithTitle
import com.wasin.presentation._common.WithTitle
import com.wasin.presentation._theme.main_blue
import com.wasin.presentation._theme.typography

@Composable
fun SignupScreen() {
    WithTitle(
        title = "회원가입"
    ) {
        item { NameField() }
        item { EmailField() }
        item { PasswordField() }
        item { PasswordConfirmField() }
        item { Spacer(modifier = Modifier.height(5.dp)) }
        item { BlueLongButton(text = "가입 완료") { } }
    }
}


@Composable
fun NameField() {
    TextFieldWithTitle(
        title = "이름",
        text = "",
        onValueChange = { /* onValueChange */ },
        placeholder = "3~10자 이내로 입력해주세요.",
    )
}

@Composable
fun EmailField() {
    Column {
        TextFieldWithTitle(
            title = "이메일",
            text = "",
            onValueChange = { /* onValueChange */ },
            placeholder = "이메일 형식을 지켜주세요.",
            keyboardType = KeyboardType.Email
        )
        EmailCodeField{ /* onClick */ }
        GrayLongButton(
            text = "인증번호 확인",
            onClick = { /* onClick */ }
        )
    }
}

@Composable
fun EmailCodeField(
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .padding(top = 9.dp, bottom = 18.dp)
            .fillMaxWidth()
            .height(44.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TextField(
            modifier = Modifier.weight(0.7f),
            text = "",
            onValueChange = { },
            placeholder = "인증번호",
            keyboardType = KeyboardType.Number
        )
        DefaultButton(
            text = "인증번호 발송 02:57",
            modifier = Modifier.weight(1f),
            color = Color.White,
            textColor = main_blue,
            border = BorderStroke(1.dp, main_blue),
            style = typography.bodyLarge,
            onClick = onClick
        )
    }
}

@Composable
fun PasswordField() {
    TextFieldWithTitle(
        title = "패스워드",
        text = "",
        onValueChange = { /* onValueChange */ },
        placeholder = "숫자, 영어, 특수문자를 포함하여 작성해주세요.",
        keyboardType = KeyboardType.Password
    )
}

@Composable
fun PasswordConfirmField() {
    TextFieldWithTitle(
        title = "패스워드 확인",
        text = "",
        onValueChange = { /* onValueChange */ },
        placeholder = "한 번 더 패스워드를 입력해주세요.",
        keyboardType = KeyboardType.Password
    )
}
