package com.example.myportfolioadminapp.common.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SpacerHeightComponent(dp: Dp) {
    Spacer(modifier = Modifier.height(dp))
}


@Composable
fun SpacerWidthComponent(dp: Dp) {
    Spacer(modifier = Modifier.width(dp))
}