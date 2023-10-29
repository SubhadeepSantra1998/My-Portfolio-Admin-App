package com.example.myportfolioadminapp.feature.education_category.presentation.update_category

sealed class UpdateCategoryUiEvent{

    data class TitleChanged(val title: String) : UpdateCategoryUiEvent()
    data class DescriptionChanged(val description: String) : UpdateCategoryUiEvent()
    data class StatusChanged(val status: Boolean) : UpdateCategoryUiEvent()
    data object UpdateCategory : UpdateCategoryUiEvent()

}