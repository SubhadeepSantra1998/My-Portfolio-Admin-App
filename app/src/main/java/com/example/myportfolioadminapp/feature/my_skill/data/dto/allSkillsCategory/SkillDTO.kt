package com.example.myportfolioadminapp.feature.my_skill.data.dto.allSkillsCategory

import com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory.SkillModel


data class SkillDTO(
    val categoryId: String,
    val createdAt: Long,
    val description: String,
    val id: String,
    val name: String,
    val proficiency: Int,
    val status: Int,
    val updatedAt: Long
)
fun SkillDTO.toSkillModel(): SkillModel {
    return SkillModel(
        id = id,
        description = description,
        name = name,
        proficiency = proficiency
    )
}