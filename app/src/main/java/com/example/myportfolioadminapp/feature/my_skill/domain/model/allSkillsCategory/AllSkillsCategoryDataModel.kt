package com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory

data class AllSkillsCategoryDataModel(
    val description: String,
    val skill: List<SkillModel>? = null,
    val title: String
)