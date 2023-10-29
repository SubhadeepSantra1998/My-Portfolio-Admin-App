package com.example.myportfolioadminapp.feature.my_education.presentation.my_education

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_education.domain.use_cases.MyEducationUseCases
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
class MyEducationViewModel @Inject constructor(
    private val myEducationUseCases: MyEducationUseCases
): ViewModel()
{

    private val _state = MutableStateFlow(MyEducationUiState())
    val state: StateFlow<MyEducationUiState> =  _state.asStateFlow()

    init {
        getAllMyEducations()
    }

    fun onUpdateConfirmationDialog(educationId: String, board: String, course: String?) {
        _state.update {
            it.copy(
                showUpdateDialog = true,
                educationId = educationId,
                board = board,
                course = course
            )
        }
    }

    fun onDeleteConfirmationDialog(educationId: String, board: String, course: String?) {
        _state.update {
            it.copy(
                showDeleteDialog = true,
                educationId = educationId,
                board = board,
                course = course
            )
        }
    }

    fun onDialogDeleteConfirm() {
        deleteEducation()
        resetDeleteDialog()
    }

    private fun deleteEducation() {
        myEducationUseCases.deleteMyEducationUseCase(state.value.educationId)
            .onStart {
                _state.update {
                    it.copy(
                        isDeleteLoading = true,
                        isDeleteSuccess = false
                    )
                }
            }
            .onEach { result ->

                _state.value = when (result) {
                    is Resource.Loading -> {
                        _state.value.copy(
                            isDeleteLoading = true,
                            isDeleteSuccess = false
                        )
                    }

                    is Resource.Success -> {
                        _state.value.copy(
                            isDeleteLoading = false,
                            isDeleteSuccess = true
                        )
                    }

                    is Resource.Error -> {
                        _state.value.copy(
                            isDeleteLoading = false,
                            isDeleteSuccess = false,
                            error = result.message
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun getAllMyEducations() {
        myEducationUseCases.getAllMyEducationUseCase()
            .onStart {
                _state.value = _state.value.copy(
                    isLoading = true
                )
            }
            .onEach { result ->
                _state.value = when (result) {
                    is Resource.Success -> {
                        _state.value.copy(
                            isLoading = false,
                            myEducation = result.data?: emptyList()
                        )
                    }

                    is Resource.Error -> {
                        _state.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                    is Resource.Loading -> {
                        _state.value.copy(
                            isLoading = true,
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }


    fun resetUpdateDialog() {
        _state.update {
            it.copy(
                showUpdateDialog = false
            )
        }
    }

    fun resetDeleteDialog() {
        _state.update {
            it.copy(
                showDeleteDialog = false
            )
        }
    }


}