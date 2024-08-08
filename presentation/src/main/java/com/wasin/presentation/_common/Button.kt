package com.wasin.presentation._common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wasin.presentation._theme.gray_C9C9C9
import com.wasin.presentation._theme.gray_E8E8E8
import com.wasin.presentation._theme.main_blue
import com.wasin.presentation._theme.typography
import com.wasin.presentation.util.NoRippleInteractionSource

@Composable
fun BlueLongButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit = {}
) {
    DefaultButton(
        text = text,
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun WhiteLongButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit = {}
) {
    DefaultButton(
        text = text,
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        color = Color.White,
        textColor = main_blue,
        border = BorderStroke(1.dp, main_blue),
    )
}

@Composable
fun GrayLongButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit = {}
) {
    DefaultButton(
        text = text,
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        color = gray_E8E8E8,
        textColor = Color.Black,
        style = typography.bodyLarge,
        padding = 9.dp
    )
}

@Composable
fun ShortButton(
    text: String = "",
    onClick: () -> Unit,
    isSelected: Boolean = false
) {
    var selected by remember { mutableStateOf(isSelected) }
    DefaultButton(
        text = text,
        modifier = Modifier.wrapContentWidth(),
        color = if(selected) main_blue else Color.White,
        textColor = if(selected) Color.White else Color.Black,
        border = if(selected) null else BorderStroke(1.dp, gray_C9C9C9),
        shape = RoundedCornerShape(30.dp),
        style = typography.titleSmall,
        padding = 5.dp,
        onClick = {
            onClick()
            selected = !selected
        },
    )
}

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "",
    color: Color = main_blue,
    textColor: Color = Color.White,
    border: BorderStroke? = null,
    shape: Shape = RoundedCornerShape(10.dp),
    padding: Dp = 13.dp,
    style: TextStyle = typography.displayLarge
) {
    Button(
        modifier = modifier.wrapContentHeight(),
        onClick = onClick,
        shape = shape,
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = padding),
        interactionSource = NoRippleInteractionSource,
        border = border,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor,
        ),
    ){
        Text(
            text = text,
            style = style,
            textAlign = TextAlign.Center
        )
    }
}
