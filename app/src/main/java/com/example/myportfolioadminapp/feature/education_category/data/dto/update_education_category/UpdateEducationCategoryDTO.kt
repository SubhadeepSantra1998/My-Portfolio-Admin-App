package com.example.myportfolioadminapp.feature.education_category.data.dto.update_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.update_education_category.UpdateEducationCategoryModel

data class UpdateEducationCategoryDTO(
    val data: Any,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun UpdateEducationCategoryDTO.toUpdateEducationCategoryModel(): UpdateEducationCategoryModel {
    return UpdateEducationCategoryModel(
        errorCode = errorCode,
        message = message
    )
}