package com.wasin.presentation._common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wasin.presentation._theme.typography


@Composable
fun WithTitle(
    title: String = "",
    description: String? = null,
    content: LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = Modifier.background(Color.White),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item { TitleAndContents(title, description) }
        content()
        item { Spacer(modifier = Modifier.height(10.dp)) }
    }
}

@Composable
fun TitleAndContents(
    text: String,
    description: String?
) {
    Column (
        modifier = Modifier.padding(top = 30.dp)
    ){
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
