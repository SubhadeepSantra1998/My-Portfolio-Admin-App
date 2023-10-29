package com.example.myportfolioadminapp.feature.skill_category.presentation.update_category

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_category.GetCategoryDataModel


data class UpdateCategoryUiState(

    val title: String = "",
    val titleError: Int? = null,
    val titleErrorStatus: Boolean = false,
    val description: String = "",
    val descriptionError: Int? = null,
    val descriptionErrorStatus: Boolean = false,
    val status: Boolean = false,
    val categoryId: String = "",
    val isLoading: Boolean = false,
    val isUpdating: Boolean = false,
    val categoryResponse: GetCategoryDataModel? = null,
    val isUpdateSuccessful: Boolean = false,
    val error : String? = null,
    val isInputValidated: Boolean = false
)
