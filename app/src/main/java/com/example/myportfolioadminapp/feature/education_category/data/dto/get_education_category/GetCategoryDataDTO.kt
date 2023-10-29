package com.example.myportfolioadminapp.feature.education_category.data.dto.get_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_education_category.GetCategoryDataModel

data class GetCategoryDataDTO(
    val createdAt: Long,
    val description: String,
    val education: Any,
    val id: String,
    val status: Int,
    val title: String,
    val updatedAt: Long
)

fun GetCategoryDataDTO.toGetCategoryDataModel(): GetCategoryDataModel {
    return GetCategoryDataModel(
        description = description,
        id = id,
        status = status,
        title = title
    )
}