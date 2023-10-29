package com.example.myportfolioadminapp.feature.my_skill.presentation.add_my_skill

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
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
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
import com.example.myportfolioadminapp.common.component.HeadingTextComponent
import com.example.myportfolioadminapp.common.component.OutlinedEditTextComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent
import com.example.myportfolioadminapp.common.component.SpacerWidthComponent
import com.example.myportfolioadminapp.common.util.toPercentage
import com.example.myportfolioadminapp.feature.my_skill.presentation.components.DropdownMenuComponent


@Composable
fun AddMySkillScreen(
    navController: NavHostController,
    viewModel: AddMySkillViewModel = hiltViewModel()
) {

    var selectedOptionText: String = if (viewModel.uiState.allCategories.isNotEmpty()) {
        viewModel.uiState.allCategories[0].title
    } else {
        "Please select"
    }



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
                HeadingTextComponent(text = stringResource(id = R.string.add_skill))

            }



            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                OutlinedEditTextComponent(
                    textState = viewModel.uiState.name,
                    onTextChange = {viewModel.onEvent(AddMySkillUiEvent.NameChanged(it))},
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.name),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )


                SpacerHeightComponent(dp = 16.dp)
                OutlinedEditTextComponent(
                    textState = viewModel.uiState.description,
                    onTextChange = {viewModel.onEvent(AddMySkillUiEvent.DescriptionChanged(it))},
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.description),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = false
                )

                SpacerHeightComponent(dp = 16.dp)
                Text(text = viewModel.uiState.proficiency.toPercentage())
                Slider(
                    value = viewModel.uiState.proficiency,
                    onValueChange = {viewModel.onEvent(AddMySkillUiEvent.ProficiencyChanged(it))}
                )


                SpacerHeightComponent(dp = 16.dp)
                Text(text = viewModel.uiState.status.toString())
                Checkbox(
                    checked = viewModel.uiState.status,
                    onCheckedChange = {
                        viewModel.onEvent(AddMySkillUiEvent.StatusChanged(it))
                    }
                )


                SpacerHeightComponent(dp = 16.dp)
                DropdownMenuComponent(
                    selectedOptionText = selectedOptionText,
                    allSkillCategories  = viewModel.uiState.allCategories,
                    isLoading = viewModel.uiState.isCategoryLoading
                ) {
                    viewModel.onEvent(AddMySkillUiEvent.OnCategoryMenuChanged(it))
                }

                SpacerHeightComponent(dp = 16.dp)
                Button(onClick = {
                    viewModel.onEvent(AddMySkillUiEvent.SaveSkill)
                }) {
                    Text(text = "Save")
                }

            }
        }
    }
}