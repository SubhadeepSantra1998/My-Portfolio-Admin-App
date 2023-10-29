package com.example.myportfolioadminapp.feature.my_skill.presentation.update_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_skill.GetSkillDataModel

data class UpdateMySkillUiState(

    val name: String = "",
    val nameError: Int? = null,
    val description: String = "",
    val descriptionError: Int? = null,
    val proficiency: Float = 0f,
    val proficiencyError: Int? = null,
    val status: Boolean = false,
    val statusError: Int? = null,

    val skillId: String = "",


    val isLoading: Boolean = false,
    val skillResponse: GetSkillDataModel? = null,
    val updateResponseMessage: String? = null,
    val error : String? = null
)
