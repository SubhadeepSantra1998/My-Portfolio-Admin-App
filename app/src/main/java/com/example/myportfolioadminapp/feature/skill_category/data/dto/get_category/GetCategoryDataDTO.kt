package com.example.myportfolioadminapp.feature.skill_category.data.dto.get_category

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_category.GetCategoryDataModel

data class GetCategoryDataDTO(
    val createdAt: Long,
    val description: String,
    val id: String,
    val skill: Any,
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