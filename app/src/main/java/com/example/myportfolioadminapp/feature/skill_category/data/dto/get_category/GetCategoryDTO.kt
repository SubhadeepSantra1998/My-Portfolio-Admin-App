package com.example.myportfolioadminapp.feature.skill_category.data.dto.get_category

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_category.GetCategoryModel

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