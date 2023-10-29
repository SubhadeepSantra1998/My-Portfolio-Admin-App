package com.example.myportfolioadminapp.feature.my_skill.data.dto.allSkillsCategory

import com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory.AllSkillCategoryModel


data class AllSkillCategoryDTO(
    val data: List<AllSkillsCategoryDataDTO>,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun AllSkillCategoryDTO.toAllSkillCategoryModel(): AllSkillCategoryModel {
    return AllSkillCategoryModel(
        data = data.map { it.toDataModel() },
        errorCode = errorCode,
        message = message,
        success = success
    )
}