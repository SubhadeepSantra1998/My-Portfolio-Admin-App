package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases


import com.example.myportfolioadminapp.feature.skill_category.domain.use_cases.GetAllSkillCategoryUseCase
import javax.inject.Inject


data class AddSkillUseCases @Inject constructor(
    val validateTitle: ValidateName,
    val validateDescription: ValidateDescription,
    val validateProficiency: ValidateProficiency,
    val saveSkill: InsertSkillUseCase,
    val getAllCategories : GetAllSkillCategoryUseCase
)