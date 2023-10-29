package com.example.myportfolioadminapp.feature.education_category.domain.model.add_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.add_education_category.AddEducationCategoryDataModel

data class AddEducationCategoryModel(
    val data: AddEducationCategoryDataModel? = null,
    val errorCode: Int? = null,
    val message: String? =null,
    val success: Boolean? =null
)