package com.example.myportfolioadminapp.feature.my_skill.presentation.add_my_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.insert_skill.InsertSkillDataModel
import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_all_categories.DataModel


data class AddMySkillUiState(

    val name: String = "",
    val nameError: Int? = null,
    val description: String = "",
    val descriptionError: Int? = null,
    val proficiency: Float = 0f,
    val proficiencyError: Int? = null,
    val status: Boolean = false,
    val statusError: Int? = null,

    val categoryId: String = "",


    val isCategoryLoading: Boolean = false,
    val isLoading: Boolean = false,
    val allCategories: List<DataModel> = emptyList(),
    val insertSkillResponse: InsertSkillDataModel? = null,
    val error : String? = null
)
