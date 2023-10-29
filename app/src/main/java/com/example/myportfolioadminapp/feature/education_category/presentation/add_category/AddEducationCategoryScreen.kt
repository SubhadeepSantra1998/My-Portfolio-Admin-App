package com.example.myportfolioadminapp.feature.education_category.presentation.add_category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.common.component.BackButtonComponent
import com.example.myportfolioadminapp.common.component.ErrorSnackBarComponent
import com.example.myportfolioadminapp.common.component.HeadingTextComponent
import com.example.myportfolioadminapp.common.component.LoadingBarComponent
import com.example.myportfolioadminapp.common.component.OutlinedEditTextComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent
import com.example.myportfolioadminapp.common.component.TextError
import com.example.myportfolioadminapp.common.component.rememberSnackieState


@Composable
fun AddEducationCategoryScreen(
    navController: NavHostController,
    viewModel: AddEducationCategoryViewModel = hiltViewModel()
) {

    val state = viewModel.uiState
    val snackbarState = rememberSnackieState()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 4.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButtonComponent(onClick = {
                    navController.navigateUp()
                })
                HeadingTextComponent(text = stringResource(id = R.string.add_category))
            }


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                OutlinedEditTextComponent(
                    textState = state.title,
                    onTextChange = { viewModel.onEvent(AddEducationCategoryUiEvent.TitleChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.title),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )
                state.titleError?.let { error ->
                    TextError(errorMessage = stringResource(id = error))
                }


                SpacerHeightComponent(dp = 16.dp)
                OutlinedEditTextComponent(
                    textState = viewModel.uiState.description,
                    onTextChange = {
                        viewModel.onEvent(
                            AddEducationCategoryUiEvent.DescriptionChanged(
                                it
                            )
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.description),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )
                state.descriptionError?.let { error ->
                    TextError(errorMessage = stringResource(id = error))
                }


                SpacerHeightComponent(dp = 16.dp)
                androidx.compose.material3.Text(text = viewModel.uiState.status.toString())
                Checkbox(
                    checked = viewModel.uiState.status,
                    onCheckedChange = {
                        viewModel.onEvent(AddEducationCategoryUiEvent.StatusChanged(it))
                    }
                )

                SpacerHeightComponent(dp = 16.dp)
                Button(
                    enabled = state.isInputValidated,
                    onClick = {
                    viewModel.onEvent(AddEducationCategoryUiEvent.SaveCategory)
                }) {
                    androidx.compose.material3.Text(text = "Save")
                }
            }
        }

        if (state.isLoading){
            LoadingBarComponent(modifier = Modifier.align(Alignment.Center))
        }

        if(state.isEducationCategorySaved){
            navController.navigateUp()
            viewModel.resetIsEducationCategorySaved()
        }


        viewModel.uiState.error?.let {
            snackbarState.addMessage(it)
            viewModel.resetError()
        }


        ErrorSnackBarComponent(state = snackbarState)
    }
}