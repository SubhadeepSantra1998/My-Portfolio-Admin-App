package com.example.myportfolioadminapp.feature.skill_category.presentation.add_category

sealed class AddCategoryUiEvent{

    data class TitleChanged(val title: String) : AddCategoryUiEvent()
    data class DescriptionChanged(val description: String) : AddCategoryUiEvent()
    data class StatusChanged(val status: Boolean) : AddCategoryUiEvent()
    data object SaveCategory : AddCategoryUiEvent()

}