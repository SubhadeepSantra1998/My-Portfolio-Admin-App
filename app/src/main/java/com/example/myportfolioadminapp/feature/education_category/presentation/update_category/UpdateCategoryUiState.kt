package com.example.myportfolioadminapp.feature.education_category.presentation.update_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_education_category.GetCategoryDataModel

data class UpdateCategoryUiState(

    val title: String = "",
    val titleError: Int? = null,
    val titleErrorStatus: Boolean = false,
    val description: String = "",
    val descriptionError: Int? = null,
    val descriptionErrorStatus: Boolean = false,
    val isInputValidated: Boolean = false,
    val status: Boolean = false,
    val categoryId: String = "",
    val isLoading: Boolean = false,
    val categoryResponse: GetCategoryDataModel? = null,
    val isUpdateCategorySuccess: Boolean = false,
    val error : String? = null
)
