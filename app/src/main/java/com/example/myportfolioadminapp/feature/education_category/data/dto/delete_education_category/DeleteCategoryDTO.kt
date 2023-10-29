package com.example.myportfolioadminapp.feature.education_category.data.dto.delete_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.delete_education_category.DeleteCategoryModel

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