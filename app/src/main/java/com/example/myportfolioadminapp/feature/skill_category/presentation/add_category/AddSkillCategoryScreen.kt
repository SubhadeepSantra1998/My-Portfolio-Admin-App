package com.example.myportfolioadminapp.feature.skill_category.presentation.add_category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.example.myportfolioadminapp.common.component.LoadingBarComponent
import com.example.myportfolioadminapp.common.component.OutlinedEditTextComponent
import com.example.myportfolioadminapp.common.component.PrimaryButtonComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent


@Composable
fun AddSkillCategoryScreen(
    navController: NavHostController,
    viewModel: AddSkillCategoryViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()


    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 4.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
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

                
                SpacerHeightComponent(dp = 16.dp)
                OutlinedEditTextComponent(
                    textState = state.title,
                    onTextChange = { viewModel.onEvent(AddCategoryUiEvent.TitleChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.title),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = state.titleErrorStatus,
                    errorMessage = state.titleError
                )


                SpacerHeightComponent(dp = 16.dp)
                OutlinedEditTextComponent(
                    textState = state.description,
                    onTextChange = { viewModel.onEvent(AddCategoryUiEvent.DescriptionChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.description),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    errorStatus = state.descriptionErrorStatus,
                    errorMessage = state.descriptionError
                )


                SpacerHeightComponent(dp = 4.dp)
                CheckboxComponents(
                    modifier = Modifier
                        .align(Alignment.Start),
                    text = if (state.status) "I want to keep this category visible" else "I don't want to keep this category visible",
                    checked = state.status,
                    onCheckboxClick = {
                        viewModel.onEvent(AddCategoryUiEvent.StatusChanged(it))
                    }
                )

                SpacerHeightComponent(dp = 32.dp)
                PrimaryButtonComponent(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Save",
                    onClick = {
                        viewModel.onEvent(AddCategoryUiEvent.SaveCategory)
                    }
                )
            }
        }

        if (state.isLoading){
            LoadingBarComponent(modifier = Modifier.align(Alignment.Center))
        }

        if(state.isSkillInsertionSuccess){
            navController.navigateUp()
            //viewModel.resetIsEducationCategorySaved()
        }


        state.error?.let {

        }
    }
}