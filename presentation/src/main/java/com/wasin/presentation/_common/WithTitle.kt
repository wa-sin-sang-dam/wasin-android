package com.wasin.presentation._common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.wasin.presentation._theme.Dimens
import com.wasin.presentation._theme.typography


@Composable
fun WithTitle(
    modifier: Modifier = Modifier,
    title: String = "",
    description: String? = null,
    content: LazyListScope.() -> Unit
) {
    val focusManager = LocalFocusManager.current
    LazyColumn(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(Dimens.ScreenPadding)
            .addFocusCleaner(focusManager),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item { TitleAndContents(title, description) }
        content()
    }
}

@Composable
fun TitleAndContents(
    text: String,
    description: String?
) {
    Column {
        Text(
            text = text,
            style = typography.titleLarge
        )
        GrayDivider(
            modifier = Modifier.padding(top = 8.dp, bottom = 15.dp)
        )
        if (description != null) {
            Text(
                text = description,
                style = typography.bodyMedium
            )
        }
    }
}
