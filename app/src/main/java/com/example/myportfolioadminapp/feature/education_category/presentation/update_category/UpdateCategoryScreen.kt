package com.example.myportfolioadminapp.feature.education_category.presentation.update_category

import android.util.Log
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.common.component.BackButtonComponent
import com.example.myportfolioadminapp.common.component.ErrorSnackBarComponent
import com.example.myportfolioadminapp.common.component.HeadingTextComponent
import com.example.myportfolioadminapp.common.component.LoadingBarComponent
import com.example.myportfolioadminapp.common.component.OutlinedEditTextComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent
import com.example.myportfolioadminapp.common.component.rememberSnackieState
import com.example.myportfolioadminapp.feature.education_category.presentation.viewModel.SharedViewModel
import com.example.myportfolioadminapp.R

@Composable
fun UpdateEducationCategoryScreen(
    navController: NavHostController,
    viewModel: UpdateCategoryViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = hiltViewModel()
) {

    val state = viewModel.uiState
    val snackbarState = rememberSnackieState()


    Log.d("hghvh",sharedViewModel.updateStatus.toString() )

    var newData by remember { mutableStateOf("") }



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
                HeadingTextComponent(text = stringResource(id = R.string.update_category))
            }


            SpacerHeightComponent(dp = 16.dp)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                    OutlinedEditTextComponent(
                        textState = state.title,
                        onTextChange = { viewModel.onEvent(UpdateCategoryUiEvent.TitleChanged(it))},
                        modifier = Modifier.fillMaxWidth(),
                        label = stringResource(id = R.string.title),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        errorStatus = state.titleErrorStatus,
                        errorMessage = state.titleError
                    )


                SpacerHeightComponent(dp = 16.dp)
                OutlinedEditTextComponent(
                    textState = state.description,
                    onTextChange = { viewModel.onEvent(UpdateCategoryUiEvent.DescriptionChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.description),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = state.descriptionErrorStatus,
                    errorMessage = state.descriptionError

                )


                SpacerHeightComponent(dp = 16.dp)
                Text(text = state.status.toString())
                Checkbox(
                    checked = state.status,
                    onCheckedChange = {
                        viewModel.onEvent(UpdateCategoryUiEvent.StatusChanged(it))
                    }
                )

                SpacerHeightComponent(dp = 16.dp)
                Button(
                    enabled = state.isInputValidated,
                    onClick = {
                    viewModel.onEvent(UpdateCategoryUiEvent.UpdateCategory)
                }) {
                    Text(text = "Update")
                }
            }
        }

        if (state.isLoading){
            LoadingBarComponent(modifier = Modifier.align(Alignment.Center))
        }


//        state.updateResponseMessage?.let {
//            snackbarState.addMessage(it)
//            viewModel.resetError()
//        }

//        if(state.isUpdateCategorySuccess){
//            sharedViewModel.setUpdateStatus(true)
//        }

        newData = "true"

        sharedViewModel.setUpdateStatus(newData)

        Log.d("jbcsj", sharedViewModel.updateStatus.value.toString())


        state.error?.let {
            snackbarState.addMessage(it)
            viewModel.resetError()
        }
        ErrorSnackBarComponent(state = snackbarState)

    }
}