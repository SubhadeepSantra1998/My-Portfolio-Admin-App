package com.example.myportfolioadminapp.feature.my_skill.domain.model.get_skill

data class GetSkillDataModel(
    val id: String,
    val description: String,
    val name: String,
    val proficiency: Int,
    val status: Int
)