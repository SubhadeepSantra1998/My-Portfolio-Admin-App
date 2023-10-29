package com.example.myportfolioadminapp.feature.education_category.domain.model.get_all_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_all_education_category.AllEducationCategoryDataModel

data class AllEducationCategoryModel(
    val data: List<AllEducationCategoryDataModel>? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)