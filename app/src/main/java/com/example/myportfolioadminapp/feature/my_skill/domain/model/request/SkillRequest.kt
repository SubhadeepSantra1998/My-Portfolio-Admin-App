package com.example.myportfolioadminapp.feature.my_skill.domain.model.request

import kotlinx.serialization.Serializable

@Serializable
data class SkillRequest(
    val name: String,
    val description: String,
    val proficiency: Int,
    val status: Int
)
