package com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_all_categories

data class GetAllSkillCategoriesModel(
    val data: List<DataModel>? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)