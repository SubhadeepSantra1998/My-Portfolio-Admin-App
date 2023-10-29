package com.example.myportfolioadminapp.feature.education_category.domain.model.get_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_education_category.GetCategoryDataModel

data class GetCategoryModel(
    val data: GetCategoryDataModel? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)