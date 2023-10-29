package com.example.myportfolioadminapp.feature.my_skill.presentation.update_skill

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Constants
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_skill.domain.model.request.SkillRequest
import com.example.myportfolioadminapp.feature.my_skill.domain.use_cases.UpdateMySkillUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpdateSkillViewModel @Inject constructor(
    private val updateMySkillUseCase: UpdateMySkillUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel()
{

    var uiState by mutableStateOf(UpdateMySkillUiState())
        private set


    init {
        savedStateHandle.get<String>(Constants.PARAM_SKILL_ID)?.let { skillId->
            getSkill(skillId)
        }
    }

    private fun getSkill(skillId: String) {
        updateMySkillUseCase.getSkill(skillId)
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
                            skillResponse = result.data,
                            skillId = result.data?.id!!,
                            name = result.data.name,
                            description = result.data.description,
                            proficiency = result.data.proficiency.toFloat(),
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


    fun onEvent(event: UpdateMySkillUiEvent){
        when (event){
            is UpdateMySkillUiEvent.NameChanged -> {
                uiState = uiState.copy(name = event.name)
            }
            is UpdateMySkillUiEvent.DescriptionChanged -> {
                uiState = uiState.copy(description = event.description)
            }
            is UpdateMySkillUiEvent.ProficiencyChanged -> {
                uiState = uiState.copy(proficiency = event.proficiency)
            }
            is UpdateMySkillUiEvent.StatusChanged -> {
                uiState = uiState.copy(status = event.status)
            }
            is UpdateMySkillUiEvent.UpdateSkill -> {
                updateSkill()
            }
        }
    }

    private fun updateSkill() {
        val nameResult = updateMySkillUseCase.validateName(uiState.name)
        val descriptionResult = updateMySkillUseCase.validateDescription(uiState.description)
        val proficiencyResult = updateMySkillUseCase.validateProficiency(uiState.proficiency)

        val hasError = listOf(
            nameResult, descriptionResult, proficiencyResult
        ).any { !it.isSuccess }

        uiState = if (hasError) {
            uiState.copy(
                nameError = nameResult.errorMessage,
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
            val updateSkillRequest = SkillRequest(
                name = uiState.name,
                description = uiState.description,
                proficiency = uiState.proficiency.toInt(),
                status = if(uiState.status) 1 else 0
            )

            updateMySkillUseCase.update(uiState.skillId, updateSkillRequest)
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
                                updateResponseMessage = result.message
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