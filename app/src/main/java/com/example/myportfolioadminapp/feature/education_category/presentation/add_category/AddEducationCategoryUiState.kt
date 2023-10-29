package com.example.myportfolioadminapp.feature.education_category.presentation.add_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.add_education_category.AddEducationCategoryDataModel
import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_category.AllCategoriesDataModel

data class AddEducationCategoryUiState(
    val title: String = "",
    val titleError: Int? = null,
    val description: String = "",
    val descriptionError: Int? = null,
    val status: Boolean = false,
    val statusError: Int? = null,

    val categoryId: String = "",


    val isLoading: Boolean = false,
    val allCategories: List<AllCategoriesDataModel> = emptyList(),
    val addEducationCategoryResponse: AddEducationCategoryDataModel? = null,
    val error : String? = null,

    val isEducationCategorySaved: Boolean = false,
    val isInputValidated: Boolean = false

)
