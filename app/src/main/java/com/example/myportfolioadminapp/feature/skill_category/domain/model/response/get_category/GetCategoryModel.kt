package com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_category

data class GetCategoryModel(
    val data: GetCategoryDataModel? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)