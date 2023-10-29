package com.example.myportfolioadminapp.common.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun CheckboxComponents(
    modifier: Modifier = Modifier,
    text: String,
    checked: Boolean,
    onCheckboxClick: (Boolean)-> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                //viewModel.onEvent(AddCategoryUiEvent.StatusChanged(it))
                onCheckboxClick(it)
            }
        )
        BodyTextComponent(text = text)
    }
}