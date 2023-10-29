package com.example.myportfolioadminapp.common.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HeadingTextComponent(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Composable
fun TitleTextComponent(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
fun BodyTextComponent(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
fun LabelTextComponent(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
    )
}


@Composable
fun TextError(errorMessage: String, modifier: Modifier = Modifier) {
    Text(
        text = errorMessage,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.error,
        modifier = modifier
    )
}

