package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases

import javax.inject.Inject

data class UpdateMySkillUseCases @Inject constructor(

    val validateName: ValidateName,
    val validateDescription: ValidateDescription,
    val validateProficiency: ValidateProficiency,
    val getSkill: GetSkillBySkillIdUseCase,
    val update : UpdateSkillUseCase
)
