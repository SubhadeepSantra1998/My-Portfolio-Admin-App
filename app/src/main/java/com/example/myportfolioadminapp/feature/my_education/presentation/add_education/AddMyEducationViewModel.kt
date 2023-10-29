package com.example.myportfolioadminapp.feature.my_education.presentation.add_education

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_education.domain.use_cases.AddMyEducationUseCases
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
class AddMyEducationViewModel @Inject constructor(
    private val addMyEducationUseCases: AddMyEducationUseCases
): ViewModel() {

    private val _state = MutableStateFlow(AddMyEducationUiState())
    val state: StateFlow<AddMyEducationUiState> =  _state.asStateFlow()

    init{
        getAllEducationCategories()
    }

    fun onEvent(event: AddMyEducationUiEvent) {
        when (event) {
            is AddMyEducationUiEvent.InstitutionChanged -> {
                _state.value = _state.value.copy(institution = event.institution)
            }
            is AddMyEducationUiEvent.BoardChanged -> {
                _state.value = _state.value.copy(board = event.board)
            }
            is AddMyEducationUiEvent.LocationChanged -> {
                _state.value = _state.value.copy(location = event.location)
            }
            is AddMyEducationUiEvent.CourseChanged -> {
                _state.value = _state.value.copy(course = event.course)
            }
            is AddMyEducationUiEvent.GradeChanged -> {
                _state.value = _state.value.copy(grade = event.grade)
            }
            is AddMyEducationUiEvent.StatusChanged -> {
                _state.value = _state.value.copy(status = event.status)
            }
            is AddMyEducationUiEvent.OnCategoryMenuChanged -> {
                _state.value = _state.value.copy(categoryId = event.categoryId)
            }
            is AddMyEducationUiEvent.SaveEducation -> {
                insertEducation()
            }
        }
    }

    private fun insertEducation() {
        val institutionResult = addMyEducationUseCases.validateInstitution(state.value.institution)
        val boardResult = addMyEducationUseCases.validateBoard(state.value.board)
        val locationResult = addMyEducationUseCases.validateLocation(state.value.location)
        val gradeResult = addMyEducationUseCases.validateGrade(state.value.grade)

        val hasError = listOf(
            institutionResult, boardResult, locationResult, gradeResult
        ).any { !it.isSuccess }

        _state.value = if (hasError) {
            _state.value.copy(
                institutionError = institutionResult.errorMessage,
                boardError = boardResult.errorMessage,
                locationError = locationResult.errorMessage,
                gradeError = gradeResult.errorMessage
            )
        } else {
            _state.value.copy(
                institutionError = null,
                boardError = null,
                locationError = null,
                gradeError = null
            )
        }

//        viewModelScope.launch {
//            val addSkillRequest = SkillRequest(
//                name = state.name,
//                description = uiState.description,
//                proficiency = uiState.proficiency.toInt(),
//                status = if(uiState.status) 1 else 0
//            )
//
//            addSkillUseCase.saveSkill(uiState.categoryId, addSkillRequest)
//                .onStart {
//                    uiState = uiState.copy(
//                        isLoading = true
//                    )
//                }
//                .onEach { result ->
//                    uiState = when (result) {
//                        is Resource.Success -> {
//                            uiState.copy(
//                                isLoading = false,
//                                insertSkillResponse = result.data
//                            )
//                        }
//
//                        is Resource.Error -> {
//                            uiState.copy(
//                                isLoading = false,
//                                error = result.message
//                            )
//                        }
//                        is Resource.Loading -> {
//                            uiState.copy(
//                                isLoading = true,
//                            )
//                        }
//                    }
//                }.launchIn(viewModelScope)
//        }
    }

    private fun getAllEducationCategories() {
        addMyEducationUseCases.getAllEducationCategoriesUseCase()
            .onStart {
                _state.update {
                    it.copy(
                        isCategoryLoading = true
                    )
                }
            }
            .onEach { result ->

                _state.update {
                    when(result){
                        is Resource.Success -> {
                            it.copy(
                                isCategoryLoading = false,
                                allCategories = result.data ?: emptyList()
                            )
                        }
                        is Resource.Error -> {
                            it.copy(
                                isCategoryLoading = false,
                                error = result.message
                            )
                        }
                        is Resource.Loading -> {
                            it.copy(
                                isCategoryLoading = true,
                            )
                        }
                    }
                }
            }.launchIn(viewModelScope)
    }

}