package com.example.myportfolioadminapp.feature.my_skill.presentation.update_skill

sealed class UpdateMySkillUiEvent{

    data class NameChanged(val name: String) : UpdateMySkillUiEvent()
    data class DescriptionChanged(val description: String) : UpdateMySkillUiEvent()
    data class ProficiencyChanged(val proficiency: Float) : UpdateMySkillUiEvent()
    data class StatusChanged(val status: Boolean) : UpdateMySkillUiEvent()
    data object UpdateSkill : UpdateMySkillUiEvent()

}