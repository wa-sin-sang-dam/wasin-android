package com.wasin.presentation._common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.wasin.presentation._theme.gray_808080
import com.wasin.presentation._theme.gray_C9C9C9
import com.wasin.presentation._theme.main_blue
import com.wasin.presentation._theme.typography
import com.wasin.presentation.util.NoRippleInteractionSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    modifier: Modifier = Modifier,
    text: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val focusRequester = remember { FocusRequester() }
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 44.dp)
            .focusRequester(focusRequester),
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    ) {
        OutlinedTextFieldDefaults.DecorationBox(
            value = text,
            innerTextField = it,
            enabled = true,
            singleLine = false,
            visualTransformation = VisualTransformation.None,
            interactionSource = NoRippleInteractionSource,
            placeholder = { TextFieldPlaceHolder(placeholder) },
            colors = OutlinedTextFieldDefaults.colors(),
            contentPadding = PaddingValues(10.dp),
            container = { TextFieldOutlineBorder() },
        )
    }
}

@Composable
fun TextFieldWithTitle(
    modifier: Modifier = Modifier,
    title: String = "",
    text: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        Text(
            text = title,
            style = typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(modifier, text, onValueChange, placeholder, keyboardType)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextFieldOutlineBorder() {
    OutlinedTextFieldDefaults.ContainerBox(
        enabled = true,
        isError = false,
        interactionSource = NoRippleInteractionSource,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = Color.Black,
            containerColor = Color.White,
            focusedPlaceholderColor = gray_C9C9C9,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = gray_C9C9C9,
            cursorColor = main_blue
        ),
        shape = MaterialTheme.shapes.small
    )
}

@Composable
private fun TextFieldPlaceHolder(placeholder: String) {
    Text(
        text = placeholder,
        style = typography.bodyMedium,
        color = gray_808080,
    )
}
