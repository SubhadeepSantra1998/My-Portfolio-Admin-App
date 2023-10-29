package com.example.myportfolioadminapp.feature.education_category.data.dto.add_education_category

import com.example.myportfolioadminapp.feature.education_category.domain.model.add_education_category.AddEducationCategoryDataModel

data class AddEducationCategoryDataDTO(
    val createdAt: Long,
    val description: String,
    val education: Any,
    val id: String,
    val status: Int,
    val title: String,
    val updatedAt: Long
)
fun AddEducationCategoryDataDTO.toAddEducationCategoryDataModel(): AddEducationCategoryDataModel {
    return AddEducationCategoryDataModel(
        description = description,
        id = id,
        status = status,
        title = title
    )
}