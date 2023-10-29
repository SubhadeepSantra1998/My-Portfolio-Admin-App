package com.example.myportfolioadminapp.feature.skill_category.domain.use_cases

import com.example.myportfolioadminapp.feature.education_category.domain.use_cases.ValidateDescription
import com.example.myportfolioadminapp.feature.education_category.domain.use_cases.ValidateTitle
import javax.inject.Inject

data class UpdateCategoryUseCases @Inject constructor(
    val getCategoryUseCase: GetCategoryUseCase,
    val validateTitle: ValidateTitle,
    val validateDescription: ValidateDescription,
    val updateCategoryUseCase: UpdateCategoryUseCase
)