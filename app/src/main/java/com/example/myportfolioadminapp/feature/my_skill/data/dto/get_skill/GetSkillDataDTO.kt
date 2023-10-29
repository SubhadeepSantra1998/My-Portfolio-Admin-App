package com.example.myportfolioadminapp.feature.my_skill.data.dto.get_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_skill.GetSkillDataModel

data class GetSkillDataDTO(
    val categoryId: String,
    val createdAt: Long,
    val description: String,
    val id: String,
    val name: String,
    val proficiency: Int,
    val status: Int,
    val updatedAt: Long
)

fun GetSkillDataDTO.toGetSkillDataModel(): GetSkillDataModel {
    return GetSkillDataModel(
        id = id,
        description = description,
        name = name,
        proficiency = proficiency,
        status = status
    )
}