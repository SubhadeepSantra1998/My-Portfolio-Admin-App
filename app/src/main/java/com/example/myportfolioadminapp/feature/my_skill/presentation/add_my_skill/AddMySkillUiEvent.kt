package com.example.myportfolioadminapp.feature.my_skill.presentation.add_my_skill

sealed class AddMySkillUiEvent{

    data class NameChanged(val name: String) : AddMySkillUiEvent()
    data class DescriptionChanged(val description: String) : AddMySkillUiEvent()
    data class ProficiencyChanged(val proficiency: Float) : AddMySkillUiEvent()
    data class StatusChanged(val status: Boolean) : AddMySkillUiEvent()
    data class OnCategoryMenuChanged(val categoryId: String): AddMySkillUiEvent()
    data object SaveSkill : AddMySkillUiEvent()

}