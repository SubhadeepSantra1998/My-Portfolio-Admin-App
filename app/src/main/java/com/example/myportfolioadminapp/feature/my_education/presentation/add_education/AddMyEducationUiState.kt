package com.example.myportfolioadminapp.feature.my_education.presentation.add_education

import com.example.myportfolioadminapp.feature.education_category.domain.model.add_education_category.AddEducationCategoryDataModel
import com.example.myportfolioadminapp.feature.education_category.domain.model.get_all_education_category.AllEducationCategoryDataModel

data class AddMyEducationUiState(
    val institution: String = "",
    val institutionError: Int? = null,
    val board: String = "",
    val boardError: Int? = null,
    val location: String = "",
    val locationError: Int? = null,
    val course: String = "",
    val courseError: Int? = null,
    val grade: String = "",
    val gradeError: Int? = null,
    val status: Boolean = false,
    val statusError: Int? = null,

    val categoryId: String = "",
    val isCategoryLoading: Boolean = false,
    val allCategories: List<AllEducationCategoryDataModel> = emptyList(),
    val addEducationResponse: AddEducationCategoryDataModel? = null,
    val error : String? = null,

    val isEducationCategorySaved: Boolean = false,
    val isInputValidated: Boolean = false
)
