package com.example.myportfolioadminapp.feature.education_category.presentation.update_category

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Constants
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.education_category.domain.model.request.EducationCategoryRequest
import com.example.myportfolioadminapp.feature.education_category.domain.use_cases.UpdateEducationCategoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpdateCategoryViewModel @Inject constructor(
    private val updateEducationCategoryUseCases: UpdateEducationCategoryUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var uiState by mutableStateOf(UpdateCategoryUiState())
        private set

    init {
        savedStateHandle.get<String>(Constants.PARAM_CATEGORY_ID)?.let { categoryId ->
            getEducationCategory(categoryId)
        }

    }

    private fun getEducationCategory(categoryId: String) {
        updateEducationCategoryUseCases.getEducationCategoryUseCase(categoryId)
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
                            categoryResponse = result.data,
                            categoryId = result.data?.id!!,
                            title = result.data.title,
                            description = result.data.description,
                            status = result.data.status == 1
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

    fun onEvent(event: UpdateCategoryUiEvent) {
        validateInput()
        when (event) {
            is UpdateCategoryUiEvent.TitleChanged -> {
                uiState = uiState.copy(title = event.title)
            }

            is UpdateCategoryUiEvent.DescriptionChanged -> {
                uiState = uiState.copy(description = event.description)
            }

            is UpdateCategoryUiEvent.StatusChanged -> {
                uiState = uiState.copy(status = event.status)
            }

            is UpdateCategoryUiEvent.UpdateCategory -> {
                updateCategory()
            }
        }
    }

    private fun updateCategory() {

        Log.d("hvhvvj", uiState.isInputValidated.toString())

        if (uiState.isInputValidated) {
            viewModelScope.launch {
                val updateRequest = EducationCategoryRequest(
                    title = uiState.title,
                    description = uiState.description,
                    status = if (uiState.status) 1 else 0
                )
                updateEducationCategoryUseCases.updateCategoryUseCase(
                    uiState.categoryId,
                    updateRequest
                )
                    .onStart {
                        uiState = uiState.copy(
                            isLoading = true,
                            isUpdateCategorySuccess = false
                        )
                    }
                    .onEach { result ->
                        uiState = when (result) {
                            is Resource.Success -> {
                                uiState.copy(
                                    isLoading = false,
                                    isUpdateCategorySuccess = true
                                )
                            }

                            is Resource.Error -> {
                                uiState.copy(
                                    isLoading = false,
                                    error = result.message,
                                    isUpdateCategorySuccess = false
                                )
                            }

                            is Resource.Loading -> {
                                uiState.copy(
                                    isLoading = true,
                                    isUpdateCategorySuccess = false
                                )
                            }
                        }
                    }.launchIn(viewModelScope)
            }
        }
    }

    private fun validateInput() {
        val titleResult = updateEducationCategoryUseCases.validateTitle(uiState.title)
        val descriptionResult =
            updateEducationCategoryUseCases.validateDescription(uiState.description)
        val hasError = listOf(
            titleResult, descriptionResult
        ).any { !it.isSuccess }


        uiState = if (hasError) {
            uiState.copy(
                titleError = titleResult.errorMessage,
                titleErrorStatus = false,
                descriptionError = descriptionResult.errorMessage,
                descriptionErrorStatus = false,
                isInputValidated = false
            )
        } else {
            uiState.copy(
                titleError = null,
                titleErrorStatus = true,
                descriptionError = null,
                descriptionErrorStatus = true,
                isInputValidated = true
            )
        }
    }

    fun resetError() {
        uiState = uiState.copy(error = null)
    }
}