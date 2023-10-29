package com.example.myportfolioadminapp.feature.education_category.presentation.add_category

sealed class AddEducationCategoryUiEvent{

    data class TitleChanged(val title: String) : AddEducationCategoryUiEvent()
    data class DescriptionChanged(val description: String) : AddEducationCategoryUiEvent()
    data class StatusChanged(val status: Boolean) : AddEducationCategoryUiEvent()
    data object SaveCategory : AddEducationCategoryUiEvent()

}