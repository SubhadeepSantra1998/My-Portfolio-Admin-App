package com.example.myportfolioadminapp.feature.skill_category.data.dto.add_category

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.add_category.AddSkillCategoryModel

data class AddSkillCategoryDTO(
    val data: AddSkillCategoryDataDTO? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun AddSkillCategoryDTO.toAddSkillCategoryModel(): AddSkillCategoryModel {
    return AddSkillCategoryModel(
        data = data?.toDataModel(),
        errorCode = errorCode,
        message = message,
        success = success
    )
}