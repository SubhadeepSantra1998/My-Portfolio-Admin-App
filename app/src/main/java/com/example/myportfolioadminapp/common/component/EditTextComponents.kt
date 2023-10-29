package com.example.myportfolioadminapp.common.component


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun IconOutlinedEditTextComponent(
    textState: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector,
    contentDescription: String,
    keyboardOptions: KeyboardOptions,
    errorStatus: Boolean,
    errorMessage: Int? = null
) {

    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        modifier = modifier,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
        },
        textStyle = MaterialTheme.typography.titleSmall,
        isError = !errorStatus,
        supportingText = {
            errorMessage?.let { stringResource(id = it) }?.let { LabelTextComponent(text = it) }
        }
    )

}


@Composable
fun OutlinedEditTextComponent(
    textState: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    keyboardOptions: KeyboardOptions,
    errorStatus: Boolean,
    errorMessage: Int? = null

) {

    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        modifier = modifier,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        textStyle = MaterialTheme.typography.titleSmall,
        isError = !errorStatus,
        supportingText = {
            errorMessage?.let { stringResource(id = it) }?.let { LabelTextComponent(text = it) }
        }
    )

}

@Composable
fun BasicEditTextComponent(
    textState: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.None,
    placeholder: String,
) {
    TextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = imeAction
        ),
        modifier = modifier
            .fillMaxWidth(),
        maxLines = 5,
    )
}