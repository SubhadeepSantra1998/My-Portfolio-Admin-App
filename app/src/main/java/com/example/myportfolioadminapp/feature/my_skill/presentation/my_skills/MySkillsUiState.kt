package com.example.myportfolioadminapp.feature.my_skill.presentation.my_skills

import com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory.AllSkillsCategoryDataModel


data class MySkillsUiState(
    val isLoading: Boolean = false,
    val mySkills: List<AllSkillsCategoryDataModel> = emptyList(),
    val deleteSuccessResponse: String?= null,
    val error : String? = "",

    val skillId: String = "",
    val skillName : String = "",
    val showDialog: Boolean = false,
)
