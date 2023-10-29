package com.example.myportfolioadminapp.feature.my_skill.data.dto.allSkillsCategory

import com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory.AllSkillsCategoryDataModel


data class AllSkillsCategoryDataDTO(
    val createdAt: Long,
    val description: String,
    val id: String,
    val skill: List<SkillDTO>? = null,
    val status: Int,
    val title: String,
    val updatedAt: Long
)
fun AllSkillsCategoryDataDTO.toDataModel(): AllSkillsCategoryDataModel {
    return AllSkillsCategoryDataModel(
        description = description,
        skill = skill?.map { it.toSkillModel() },
        title = title
    )
}