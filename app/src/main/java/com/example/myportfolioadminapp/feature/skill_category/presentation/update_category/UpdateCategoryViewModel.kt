package com.example.myportfolioadminapp.feature.skill_category.presentation.update_category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Constants
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.skill_category.domain.model.request.SkillCategoryRequest
import com.example.myportfolioadminapp.feature.skill_category.domain.use_cases.UpdateCategoryUseCases
import com.example.portfolioadmin.feature.skill_category.presentation.update_category.UpdateCategoryUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class UpdateCategoryViewModel @Inject constructor(
    private val updateCategoryUseCases: UpdateCategoryUseCases,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _state = MutableStateFlow(UpdateCategoryUiState())
    val state: StateFlow<UpdateCategoryUiState> =  _state.asStateFlow()

    init {
        savedStateHandle.get<String>(Constants.PARAM_CATEGORY_ID)?.let { categoryId ->
            getSkillCategory(categoryId)
        }
    }

    fun onEvent(event: UpdateCategoryUiEvent) {
        validateInput()
        when (event) {
            is UpdateCategoryUiEvent.TitleChanged -> {
                _state.update { it.copy(title = event.title) }
            }
            is UpdateCategoryUiEvent.DescriptionChanged -> {
                _state.update { it.copy(description = event.description) }
            }
            is UpdateCategoryUiEvent.StatusChanged -> {
                _state.update { it.copy(status = event.status) }
            }
            is UpdateCategoryUiEvent.UpdateCategory -> {
                updateCategory()
            }
        }
    }

    private fun updateCategory() {
        val request = SkillCategoryRequest(
            title = state.value.title,
            description = state.value.description,
            status = if (state.value.status) 1 else 0
        )
        updateCategoryUseCases.updateCategoryUseCase(
            state.value.categoryId,
            request
        )
            .onStart {
                _state.update {
                    it.copy(
                        isUpdating = true,
                        isUpdateSuccessful = false
                    )
                }
            }
            .onEach { result ->
                _state.value = when (result) {
                    is Resource.Success -> {
                        _state.value.copy(
                            isUpdating = false,
                            isUpdateSuccessful = true
                        )
                    }

                    is Resource.Error -> {
                        _state.value.copy(
                            isUpdating = false,
                            error = result.message,
                            isUpdateSuccessful = false
                        )
                    }

                    is Resource.Loading -> {
                        _state.value.copy(
                            isUpdating = true,
                            isUpdateSuccessful = false
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun validateInput(): Boolean {
        val titleResult = updateCategoryUseCases.validateTitle(state.value.title)
        val descriptionResult = updateCategoryUseCases.validateDescription(state.value.description)
        val hasError = listOf(
            titleResult, descriptionResult
        ).any { !it.isSuccess }


        _state.value = if (hasError) {
            _state.value.copy(
                titleError = titleResult.errorMessage,
                titleErrorStatus = titleResult.isSuccess,
                descriptionError = descriptionResult.errorMessage,
                descriptionErrorStatus = descriptionResult.isSuccess,
                isInputValidated = false
            )
        } else {
            _state.value.copy(
                titleError = null,
                titleErrorStatus = titleResult.isSuccess,
                descriptionError = null,
                descriptionErrorStatus = descriptionResult.isSuccess,
                isInputValidated = true
            )
        }
        return state.value.isInputValidated
    }

    private fun getSkillCategory(categoryId: String) {
        updateCategoryUseCases.getCategoryUseCase(categoryId)
            .onStart {
                _state.update {
                    it.copy(
                        isLoading = true
                    )
                }
            }
            .onEach { result ->

                _state.value = when (result) {
                    is Resource.Loading -> {
                        _state.value.copy(
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _state.value.copy(
                            isLoading = false,
                            categoryResponse = result.data,
                            categoryId = result.data?.id!!,
                            title = result.data.title,
                            description = result.data.description,
                            status = result.data.status == 1
                        )
                    }

                    is Resource.Error -> {
                        _state.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

}