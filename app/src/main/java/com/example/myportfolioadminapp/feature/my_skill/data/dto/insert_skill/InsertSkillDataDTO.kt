package com.example.myportfolioadminapp.feature.my_skill.data.dto.insert_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.insert_skill.InsertSkillDataModel

data class InsertSkillDataDTO(
    val categoryId: String,
    val createdAt: Long,
    val description: String,
    val id: String,
    val name: String,
    val proficiency: Int,
    val status: Int,
    val updatedAt: Long
)

fun InsertSkillDataDTO.toInsertSkillDataModel(): InsertSkillDataModel {
    return InsertSkillDataModel(
        categoryId = categoryId,
        createdAt = createdAt,
        description = description,
        id = id,
        name = name,
        proficiency = proficiency,
        status = status,
        updatedAt = updatedAt
    )
}