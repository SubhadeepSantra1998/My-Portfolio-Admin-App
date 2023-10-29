package com.example.myportfolioadminapp.feature.my_skill.presentation.my_skills

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_skill.domain.use_cases.MySkillsUseCases
import com.example.myportfolioadminapp.feature.my_skill.presentation.my_skills.MySkillsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MySkillsViewModel @Inject constructor(
    private val mySkillsUseCase: MySkillsUseCases
): ViewModel()
{

    var uiState by mutableStateOf(MySkillsUiState())
        private set



    init {
        getAllMySkills()
    }


    fun onConfirmationDialogClicked(skillId: String, name: String) {
        uiState = uiState.copy(
            showDialog = true,
            skillId = skillId,
            skillName = name
        )
    }

    fun onDialogConfirm() {
        uiState = uiState.copy(
            showDialog = false
        )
        deleteSkill()
    }

    fun onDialogDismiss() {
        uiState = uiState.copy(
            showDialog = false
        )
    }


    private fun deleteSkill() {
        mySkillsUseCase.deleteSkill(uiState.skillId)
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
                            deleteSuccessResponse = result.message
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


    private fun getAllMySkills() {
        mySkillsUseCase.getAllSkillsCategories()
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
                            mySkills = result.data ?: emptyList()
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