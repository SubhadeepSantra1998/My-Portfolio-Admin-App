package com.example.myportfolioadminapp.feature.education_category.data.dto.get_all_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.get_all_education_category.AllEducationCategoryDataModel

data class AllEducationCategoryDataDTO(
    val createdAt: Long,
    val description: String,
    val education: Any? = null,
    val id: String,
    val status: Int,
    val title: String,
    val updatedAt: Long
)

fun AllEducationCategoryDataDTO.toAllEducationCategoryDataModel(): AllEducationCategoryDataModel {
    return AllEducationCategoryDataModel(
        description = description,
        id = id,
        status = status,
        title = title
    )
}