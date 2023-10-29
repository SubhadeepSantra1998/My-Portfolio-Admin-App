package com.example.myportfolioadminapp.feature.education_category.presentation.show_categories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.education_category.domain.use_cases.EducationCategoriesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject



@HiltViewModel
class EducationCategoryViewModel @Inject constructor(
    private val educationCategoriesUseCases: EducationCategoriesUseCases
): ViewModel() {

    var uiState by mutableStateOf(EducationCategoryUiState())
        private set
    private val _state = MutableStateFlow(EducationCategoryUiState())
    val state: StateFlow<EducationCategoryUiState> =  _state.asStateFlow()




    init {
        getAllEducationCategories()
    }






    fun getAllEducationCategories() {
        educationCategoriesUseCases.categoriesUseCase()
            .onStart {
                uiState = uiState.copy(
                    isLoading = true
                )

//                _state.update {
//                    it.copy(
//                        isLoading = true
//                    )
//                }
            }
            .onEach { result ->
                uiState = when (result) {
                    is Resource.Success -> {
                        uiState.copy(
                            isLoading = false,
                            isRefreshing = false,
                             categories = result.data ?: emptyList()
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
//                _state.value = when(result){
//                    is Resource.Success -> {
//                         _state.value?.copy(
//                            isLoading = false,
//                             categories = result.data ?: emptyList()
//                        )
//
//                    }
//                    is Resource.Error -> {
//                        _state.value?.copy(
//                            isLoading = false,
//                            error = result.message
//                        )
//                    }
//                    is Resource.Loading -> {
//                        _state.value?.copy(
//                            isLoading = true
//                        )
//                    }
//                }


//                _state.update {
//                    when(result){
//                        is Resource.Success -> {
//                            it.copy(
//                                isLoading = false,
//                                categories = result.data ?: emptyList()
//                            )
//                        }
//                        is Resource.Error -> {
//                            it.copy(
//                                isLoading = false,
//                                error = result.message
//                            )
//                        }
//                        is Resource.Loading -> {
//                            it.copy(
//                                isLoading = true,
//                            )
//                        }
//                    }
//                }
            }.launchIn(viewModelScope)
    }

    fun onUpdateConfirmationDialog(categoryId: String, title: String) {
        uiState = uiState.copy(
            showUpdateDialog = true,
            categoryId = categoryId,
            categoryTitle = title
        )
    }

    fun onDialogUpdateConfirm() {
        uiState = uiState.copy(
            showUpdateDialog = false
        )
        //updateCategory()
    }
    fun onDialogDeleteConfirm() {
        uiState = uiState.copy(
            showDeleteDialog = false
        )
        deleteCategory()
    }

    private fun deleteCategory() {
        educationCategoriesUseCases.deleteCategory(uiState.categoryId)
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

    fun onDialogDismiss() {
        uiState = uiState.copy(
            showUpdateDialog = false,
            showDeleteDialog = false
        )
    }

    fun onDeleteConfirmationDialog(categoryId: String, title: String) {
        uiState = uiState.copy(
            showDeleteDialog = true,
            categoryId = categoryId,
            categoryTitle = title
        )
    }

    fun refreshData() {
        getAllEducationCategories()
    }
}