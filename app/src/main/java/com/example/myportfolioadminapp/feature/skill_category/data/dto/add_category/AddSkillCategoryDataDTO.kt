package com.example.myportfolioadminapp.feature.skill_category.data.dto.add_category

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.add_category.DataModel

data class AddSkillCategoryDataDTO(
    val createdAt: Long,
    val description: String,
    val id: String,
    val skill: Any,
    val status: Int,
    val title: String,
    val updatedAt: Long
)


fun AddSkillCategoryDataDTO.toDataModel(): DataModel {
    return DataModel(
        description = description,
        id = id,
        status = status,
        title = title
    )
}