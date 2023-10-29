package com.example.myportfolioadminapp.feature.skill_category.presentation.show_categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.skill_category.domain.use_cases.SkillCategoriesUseCases
import com.example.myportfolioadminapp.feature.skill_category.presentation.show_categories.SkillCategoryUiState
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
class SkillCategoryViewModel @Inject constructor(
    private val skillCategoriesUseCases: SkillCategoriesUseCases
): ViewModel() {

    private val _state = MutableStateFlow(SkillCategoryUiState())
    val state: StateFlow<SkillCategoryUiState> =  _state.asStateFlow()

    init {
        getAllCategories()
    }



    fun onUpdateConfirmationDialog(categoryId: String, title: String) {
        _state.update {
            it.copy(
                showUpdateDialog = true,
                categoryId = categoryId,
                categoryTitle = title
            )
        }
    }

    fun onDeleteConfirmationDialog(categoryId: String, title: String) {
        _state.update {
            it.copy(
                showDeleteDialog = true,
                categoryId = categoryId,
                categoryTitle = title
            )
        }
    }

    fun onDialogDeleteConfirm() {
        _state.update {
            it.copy(
                showDeleteDialog = false
            )
        }
        deleteCategory()
    }

    fun onDialogDismiss() {
        _state.update {
            it.copy(
                showUpdateDialog = false,
                showDeleteDialog = false
            )
        }
    }

    private fun deleteCategory() {

        skillCategoriesUseCases.deleteCategoryUseCase(state.value.categoryId)
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


    fun getAllCategories() {
        skillCategoriesUseCases.categoriesUseCase()
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
                            isRefreshing = false,
                            categories = result.data ?: emptyList()
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
