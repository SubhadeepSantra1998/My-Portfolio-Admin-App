package com.example.myportfolioadminapp.feature.education_category.data.dto.get_all_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_all_education_category.AllEducationCategoryModel

data class AllEducationCategoryDTO(
    val data: List<AllEducationCategoryDataDTO>? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun AllEducationCategoryDTO.toAllEducationCategoryModel() : AllEducationCategoryModel {
    return AllEducationCategoryModel(
        data = data?.map { it. toAllEducationCategoryDataModel()},
        errorCode = errorCode,
        message = message,
        success = success
    )
}