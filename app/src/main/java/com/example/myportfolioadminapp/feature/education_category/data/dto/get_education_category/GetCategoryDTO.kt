package com.example.myportfolioadminapp.feature.education_category.data.dto.get_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_education_category.GetCategoryModel

data class GetCategoryDTO(
    val data: GetCategoryDataDTO? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun GetCategoryDTO.toGetCategoryModel(): GetCategoryModel {
    return GetCategoryModel(
        data = data?.toGetCategoryDataModel(),
        errorCode = errorCode,
        message = message,
        success = success
    )
}