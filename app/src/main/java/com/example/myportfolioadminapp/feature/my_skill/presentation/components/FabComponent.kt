package com.example.myportfolioadminapp.feature.my_skill.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.myportfolioadminapp.common.component.BodyTextComponent


@Composable
fun ExtendedFabComponent(
    text: String,
    expanded: Boolean,
    onButtonClick: ()-> Unit,
) {
    ExtendedFloatingActionButton(
        text = { BodyTextComponent(text = text) },
        icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = null) },
        onClick = { onButtonClick() },
        expanded = expanded
    )
}

@Composable
fun DefaultFloatingActionButton() {
    FloatingActionButton(onClick = { /* do something*/ }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
    }
}