package com.example.myportfolioadminapp.feature.skill_category.data.dto.update_category

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.update_category.UpdateCategoryModel


data class UpdateCategoryDTO(
    val data: Any,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun UpdateCategoryDTO.toUpdateCategoryModel(): UpdateCategoryModel {
    return UpdateCategoryModel(
        errorCode = errorCode,
        message = message
    )
}