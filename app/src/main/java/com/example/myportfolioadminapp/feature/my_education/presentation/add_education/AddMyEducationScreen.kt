package com.example.myportfolioadminapp.feature.my_education.presentation.add_education

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.common.component.BackButtonComponent
import com.example.myportfolioadminapp.common.component.CheckboxComponents
import com.example.myportfolioadminapp.common.component.HeadingTextComponent
import com.example.myportfolioadminapp.common.component.OutlinedEditTextComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent
import com.example.myportfolioadminapp.common.component.SpacerWidthComponent
import com.example.myportfolioadminapp.feature.my_skill.presentation.components.DropdownMenuComponent


@Composable
fun AddMyEducationScreen(
    navController: NavHostController,
    paddingValue: PaddingValues,
    viewModel: AddMyEducationViewModel = hiltViewModel()
) {

    val uiState by viewModel.state.collectAsStateWithLifecycle()

    var selectedOptionText: String = if (uiState.allCategories.isNotEmpty()) {
        uiState.allCategories[0].title
    } else {
        "Please select"
    }

    Log.d("gcgch", selectedOptionText)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButtonComponent(onClick = {
                    navController.navigateUp()
                })
                SpacerWidthComponent(dp = 8.dp)
                HeadingTextComponent(text = stringResource(id = R.string.add_education))
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                DropdownMenuComponent(
                    selectedOptionText = selectedOptionText,
                    allEducationCategories = uiState.allCategories,
                    isLoading = uiState.isCategoryLoading
                ) {
                    //viewModel.onEvent(AddMySkillUiEvent.OnCategoryMenuChanged(it))
                }


                SpacerHeightComponent(dp = 16.dp)
                OutlinedEditTextComponent(
                    textState = uiState.institution,
                    onTextChange = {viewModel.onEvent(AddMyEducationUiEvent.InstitutionChanged(it))},
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.institution),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )


                OutlinedEditTextComponent(
                    textState = uiState.board,
                    onTextChange = {viewModel.onEvent(AddMyEducationUiEvent.BoardChanged(it))},
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.board),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )


                OutlinedEditTextComponent(
                    textState = uiState.location,
                    onTextChange = {viewModel.onEvent(AddMyEducationUiEvent.LocationChanged(it))},
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.location),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )

                OutlinedEditTextComponent(
                    textState = uiState.course,
                    onTextChange = {viewModel.onEvent(AddMyEducationUiEvent.CourseChanged(it))},
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.course),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )


                OutlinedEditTextComponent(
                    textState = uiState.grade,
                    onTextChange = {viewModel.onEvent(AddMyEducationUiEvent.GradeChanged(it))},
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.location),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )

                SpacerHeightComponent(dp = 4.dp)
                CheckboxComponents(
                    modifier = Modifier
                        .align(Alignment.Start),
                    text = if (uiState.status) "I want to keep this education visible" else "I don't want to keep this education visible",
                    checked = uiState.status,
                    onCheckboxClick = {
                        viewModel.onEvent(AddMyEducationUiEvent.StatusChanged(it))
                    }
                )

                SpacerHeightComponent(dp = 16.dp)
                Button(onClick = {
                    viewModel.onEvent(AddMyEducationUiEvent.SaveEducation)
                }) {
                    Text(text = "Save")
                }
            }
        }
    }
}