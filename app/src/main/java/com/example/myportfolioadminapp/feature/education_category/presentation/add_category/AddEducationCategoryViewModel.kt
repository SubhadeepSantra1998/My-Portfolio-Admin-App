package com.example.myportfolioadminapp.feature.education_category.presentation.add_category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.education_category.domain.model.request.EducationCategoryRequest
import com.example.myportfolioadminapp.feature.education_category.domain.use_cases.EducationCategoriesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddEducationCategoryViewModel @Inject constructor(
    private val educationCategoryUseCases: EducationCategoriesUseCases
): ViewModel() {

    var uiState by mutableStateOf(AddEducationCategoryUiState())
        private set


    fun onEvent(event: AddEducationCategoryUiEvent){
        validateInput()
        when (event) {
            is AddEducationCategoryUiEvent.TitleChanged -> {
                uiState = uiState.copy(title = event.title)
            }

            is AddEducationCategoryUiEvent.DescriptionChanged -> {
                uiState = uiState.copy(description = event.description)
            }

            is AddEducationCategoryUiEvent.StatusChanged -> {
                uiState = uiState.copy(status = event.status)
            }
            is AddEducationCategoryUiEvent.SaveCategory -> {
             saveEducationCategory()
            }
        }
    }

    private fun saveEducationCategory() {
        if(uiState.isInputValidated){
            viewModelScope.launch {
                val addEducationCategoryRequest = EducationCategoryRequest(
                    title = uiState.title,
                    description = uiState.description,
                    status = if(uiState.status) 1 else 0
                )

                educationCategoryUseCases.saveCategory(addEducationCategoryRequest)
                    .onStart {
                        uiState = uiState.copy(
                            isLoading = true
                        )
                    }
                    .onEach { result ->
                        uiState = when (result) {
                            is Resource.Success -> {
                                uiState.copy(
                                    isLoading = false,
                                    addEducationCategoryResponse = result.data,
                                    isEducationCategorySaved = true
                                )
                            }

                            is Resource.Error -> {
                                uiState.copy(
                                    isLoading = false,
                                    error = result.message
                                )
                            }
                            is Resource.Loading -> {
                                uiState.copy(
                                    isLoading = true,
                                )
                            }
                        }
                    }.launchIn(viewModelScope)
            }
        }
    }

    private fun validateInput() {
        val titleResult = educationCategoryUseCases.validateTitle(uiState.title)
        val descriptionResult = educationCategoryUseCases.validateDescription(uiState.description)
        val hasError = listOf(
            titleResult, descriptionResult
        ).any { !it.isSuccess }


        uiState = if (hasError) {
            uiState.copy(
                titleError = titleResult.errorMessage,
                descriptionError = descriptionResult.errorMessage,
                isInputValidated = false
            )
        } else {
            uiState.copy(
                titleError = null,
                descriptionError = null,
                isInputValidated = true
            )
        }
    }

    fun resetIsEducationCategorySaved() {
        uiState = uiState.copy(isEducationCategorySaved = false)
    }

    fun resetError() {
        uiState = uiState.copy(error = null)
    }

}