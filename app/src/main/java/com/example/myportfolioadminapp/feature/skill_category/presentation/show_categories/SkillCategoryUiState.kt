package com.example.myportfolioadminapp.feature.skill_category.presentation.show_categories

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_all_categories.DataModel

data class SkillCategoryUiState(
    val isLoading: Boolean = false,
    val categories: List<DataModel>? = null,
    val isDeleteSuccess: Boolean = false,
    val error : String? = "",
    val categoryId: String = "",
    val categoryTitle : String = "",
    var showUpdateDialog: Boolean = false,
    val showDeleteDialog: Boolean = false,
    val isDeleteLoading: Boolean = false,
    val isRefreshing: Boolean = false,
)
