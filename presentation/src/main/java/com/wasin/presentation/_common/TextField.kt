package com.wasin.presentation._common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.wasin.presentation._theme.gray_808080
import com.wasin.presentation._theme.gray_C9C9C9
import com.wasin.presentation._theme.gray_E8E8E8
import com.wasin.presentation._theme.main_blue
import com.wasin.presentation._theme.typography
import com.wasin.presentation._util.NoRippleInteractionSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    modifier: Modifier = Modifier,
    text: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    enabled: Boolean = true
) {
    val focusRequester = remember { FocusRequester() }
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 44.dp)
            .focusRequester(focusRequester),
        textStyle = typography.bodyMedium,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        singleLine = true,
        enabled = enabled
    ) {
        OutlinedTextFieldDefaults.DecorationBox(
            value = text,
            innerTextField = it,
            enabled = enabled,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = NoRippleInteractionSource,
            placeholder = { TextFieldPlaceHolder(placeholder = placeholder) },
            colors = OutlinedTextFieldDefaults.colors(),
            contentPadding = PaddingValues(10.dp),
            container = { TextFieldOutlineBorder(enabled) },
        )
    }
}

@Composable
fun TextFieldCardWithTitle(
    onClick: () -> Unit = {},
    title: String = "",
    text: String = "",
    placeholder: String = "",
) {
    Column {
        Text(
            text = title,
            style = typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .border(BorderStroke(1.dp, gray_C9C9C9), MaterialTheme.shapes.small)
                .fillMaxWidth()
                .defaultMinSize(minHeight = 44.dp)
                .clickable(onClick = onClick),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(10.dp),
                text = if (text.isEmpty()) placeholder else text,
                style = typography.bodyMedium,
                color = if (text.isEmpty()) gray_808080 else Color.Black,
            )
        }
    }
}

@Composable
fun TextFieldWithTitle(
    modifier: Modifier = Modifier,
    title: String = "",
    text: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    enabled: Boolean = true
) {
    Column {
        Text(
            text = title,
            style = typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(modifier, text, onValueChange, placeholder, keyboardType, visualTransformation, enabled)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextFieldOutlineBorder(
    enabled: Boolean
) {
    OutlinedTextFieldDefaults.ContainerBox(
        enabled = enabled,
        isError = false,
        interactionSource = NoRippleInteractionSource,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = if (enabled) Color.Black else gray_808080,
            containerColor = if (enabled) Color.White else gray_E8E8E8,
            focusedPlaceholderColor = gray_C9C9C9,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = gray_C9C9C9,
            cursorColor = main_blue
        ),
        shape = MaterialTheme.shapes.small
    )
}

@Composable
private fun TextFieldPlaceHolder(
    modifier: Modifier = Modifier,
    placeholder: String
) {
    Text(
        modifier = modifier,
        text = placeholder,
        style = typography.bodyMedium,
        color = gray_808080,
    )
}
