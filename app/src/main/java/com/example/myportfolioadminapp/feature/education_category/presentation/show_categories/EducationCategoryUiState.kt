package com.example.myportfolioadminapp.feature.education_category.presentation.show_categories

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_all_education_category.AllEducationCategoryDataModel

data class EducationCategoryUiState(
    val isLoading: Boolean = false,
    val categories: List<AllEducationCategoryDataModel>? = null,
    val deleteSuccessResponse: String?= null,
    val error : String? = "",

    val categoryId: String = "",
    val categoryTitle : String = "",
    var showUpdateDialog: Boolean = false,
    val showDeleteDialog: Boolean = false,
    val isRefreshing: Boolean = false,
)
