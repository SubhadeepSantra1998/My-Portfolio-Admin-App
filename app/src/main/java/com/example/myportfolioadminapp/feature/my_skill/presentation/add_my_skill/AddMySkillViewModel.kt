package com.example.myportfolioadminapp.feature.my_skill.presentation.add_my_skill

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_skill.domain.model.request.SkillRequest
import com.example.myportfolioadminapp.feature.my_skill.domain.use_cases.AddSkillUseCases
import com.example.myportfolioadminapp.feature.my_skill.presentation.add_my_skill.AddMySkillUiEvent
import com.example.myportfolioadminapp.feature.my_skill.presentation.add_my_skill.AddMySkillUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class AddMySkillViewModel @Inject constructor(
    private val addSkillUseCase: AddSkillUseCases
): ViewModel()
{

    var uiState by mutableStateOf(AddMySkillUiState())
        private set


    init {
        getAllCategories()
    }

    private fun getAllCategories() {
        addSkillUseCase.getAllCategories()
            .onStart {
                uiState = uiState.copy(
                    isCategoryLoading = true
                )
            }
            .onEach { result ->
                uiState = when (result) {
                    is Resource.Success -> {
                        uiState.copy(
                            isCategoryLoading = false,
                            allCategories = result.data ?: emptyList()
                        )
                    }

                    is Resource.Error -> {
                        uiState.copy(
                            isCategoryLoading = false,
                            error = result.message
                        )
                    }
                    is Resource.Loading -> {
                        uiState.copy(
                            isCategoryLoading = true,
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }


    fun onEvent(event: AddMySkillUiEvent){
        when (event){
            is AddMySkillUiEvent.NameChanged -> {
                uiState = uiState.copy(name = event.name)
            }
            is AddMySkillUiEvent.DescriptionChanged -> {
                uiState = uiState.copy(description = event.description)
            }
            is AddMySkillUiEvent.ProficiencyChanged -> {
                uiState = uiState.copy(proficiency = event.proficiency)
            }
            is AddMySkillUiEvent.StatusChanged -> {
                uiState = uiState.copy(status = event.status)
            }
            is AddMySkillUiEvent.OnCategoryMenuChanged -> {
                uiState = uiState.copy(categoryId = event.categoryId)
            }
            is AddMySkillUiEvent.SaveSkill -> {
                insertSkill()
            }
        }
    }

    private fun insertSkill() {


        val titleResult = addSkillUseCase.validateTitle(uiState.name)
        val descriptionResult = addSkillUseCase.validateDescription(uiState.description)
        val proficiencyResult = addSkillUseCase.validateProficiency(uiState.proficiency)

        val hasError = listOf(
            titleResult, descriptionResult, proficiencyResult
        ).any { !it.isSuccess }

        uiState = if (hasError) {
            uiState.copy(
                nameError = titleResult.errorMessage,
                descriptionError = descriptionResult.errorMessage,
                proficiencyError = proficiencyResult.errorMessage
            )
        } else {
            uiState.copy(
                nameError = null,
                descriptionError = null,
                proficiencyError = null
            )
        }

        viewModelScope.launch {
            val addSkillRequest = SkillRequest(
                name = uiState.name,
                description = uiState.description,
                proficiency = uiState.proficiency.toInt(),
                status = if(uiState.status) 1 else 0
            )

            addSkillUseCase.saveSkill(uiState.categoryId, addSkillRequest)
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
                                insertSkillResponse = result.data
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