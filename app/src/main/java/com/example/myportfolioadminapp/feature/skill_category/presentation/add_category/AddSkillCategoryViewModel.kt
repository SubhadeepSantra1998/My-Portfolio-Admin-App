package com.example.myportfolioadminapp.feature.skill_category.presentation.add_category


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.skill_category.domain.model.request.SkillCategoryRequest
import com.example.myportfolioadminapp.feature.skill_category.domain.use_cases.AddSkillCategoryUseCases
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
class AddSkillCategoryViewModel @Inject constructor(
    private val addSkillCategoryUseCases: AddSkillCategoryUseCases
): ViewModel() {

    private val _state = MutableStateFlow(AddSkillCategoryUiState())
    val state: StateFlow<AddSkillCategoryUiState> =  _state.asStateFlow()


    fun onEvent(event: AddCategoryUiEvent) {

        when (event) {
            is AddCategoryUiEvent.TitleChanged -> {
                _state.update { it.copy(title = event.title) }
            }
            is AddCategoryUiEvent.DescriptionChanged -> {
                _state.update { it.copy(description = event.description) }
            }
            is AddCategoryUiEvent.StatusChanged -> {
                _state.update { it.copy(status = event.status) }
            }
            is AddCategoryUiEvent.SaveCategory -> {
                if(validateInput()){
                    saveCategory()
                }
            }
        }
    }

    private fun validateInput(): Boolean {
        val titleResult = addSkillCategoryUseCases.validateTitle(state.value.title)
        val descriptionResult = addSkillCategoryUseCases.validateDescription(state.value.description)
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

    private fun saveCategory() {

            val request = SkillCategoryRequest(
                title = state.value.title,
                description = state.value.description,
                status = if (state.value.status) 1 else 0
            )

            addSkillCategoryUseCases.addSkillUseCase(request)
                .onStart {
                    _state.update {
                        it.copy(isLoading = true)
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
                                isSkillInsertionSuccess = true

                            )
                        }

                        is Resource.Error -> {
                            _state.value.copy(
                                isLoading = false
                            )
                        }
                    }
                }.launchIn(viewModelScope)

    }
}
