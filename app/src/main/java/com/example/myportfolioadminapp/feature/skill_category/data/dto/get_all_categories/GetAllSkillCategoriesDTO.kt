package com.example.myportfolioadminapp.feature.skill_category.data.dto.get_all_categories

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_all_categories.GetAllSkillCategoriesModel

data class GetAllSkillCategoriesDTO(
    val data: List<DataDTO>? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun GetAllSkillCategoriesDTO.toGetAllSkillCategoriesModel(): GetAllSkillCategoriesModel {
    return GetAllSkillCategoriesModel(
        data = data?.map { it.toDataModel() },
        errorCode = errorCode,
        message = message,
        success = success
    )
}