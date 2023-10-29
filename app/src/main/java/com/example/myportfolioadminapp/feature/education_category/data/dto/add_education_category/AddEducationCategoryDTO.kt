package com.example.myportfolioadminapp.feature.education_category.data.dto.add_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.add_education_category.AddEducationCategoryModel

data class AddEducationCategoryDTO(
    val data: AddEducationCategoryDataDTO? = null,
    val errorCode: Int? = null,
    val message: String? =null,
    val success: Boolean? =null
)

fun AddEducationCategoryDTO.toAddEducationCategoryModel(): AddEducationCategoryModel {
    return AddEducationCategoryModel(
        data = data?.toAddEducationCategoryDataModel(),
        errorCode = errorCode,
        message = message,
        success = success
    )
}