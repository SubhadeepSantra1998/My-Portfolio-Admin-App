package com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory

data class AllSkillCategoryModel(
    val data: List<AllSkillsCategoryDataModel>,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)