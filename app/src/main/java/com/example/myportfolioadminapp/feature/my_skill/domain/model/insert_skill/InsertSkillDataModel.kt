package com.example.myportfolioadminapp.feature.my_skill.domain.model.insert_skill

data class InsertSkillDataModel(
    val categoryId: String,
    val createdAt: Long,
    val description: String,
    val id: String,
    val name: String,
    val proficiency: Int,
    val status: Int,
    val updatedAt: Long
)