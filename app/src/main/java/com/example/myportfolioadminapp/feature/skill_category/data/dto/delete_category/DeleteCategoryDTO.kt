package com.example.myportfolioadminapp.feature.skill_category.data.dto.delete_category

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.delete_category.DeleteCategoryModel


data class DeleteCategoryDTO(
    val data: Any,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun DeleteCategoryDTO.toDeleteCategoryModel(): DeleteCategoryModel {
    return DeleteCategoryModel(
        errorCode = errorCode,
        message = message
    )
}