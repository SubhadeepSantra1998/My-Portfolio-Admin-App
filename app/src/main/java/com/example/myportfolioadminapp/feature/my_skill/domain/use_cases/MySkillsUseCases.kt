package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases

import com.example.myportfolioadminapp.feature.my_skill.domain.use_cases.DeleteSkillUseCase
import com.example.myportfolioadminapp.feature.my_skill.domain.use_cases.GetAllSkillsCategoriesUseCase
import javax.inject.Inject

data class MySkillsUseCases @Inject constructor(
    val getAllSkillsCategories: GetAllSkillsCategoriesUseCase,
    val deleteSkill: DeleteSkillUseCase
)
