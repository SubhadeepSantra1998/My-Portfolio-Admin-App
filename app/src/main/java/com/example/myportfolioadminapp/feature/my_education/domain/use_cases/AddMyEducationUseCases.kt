package com.example.myportfolioadminapp.feature.my_education.domain.use_cases

import com.example.myportfolioadminapp.feature.education_category.domain.use_cases.GetAllEducationCategoryUseCase
import javax.inject.Inject

data class AddMyEducationUseCases @Inject constructor(
    val validateInstitution: ValidateInstitution,
    val validateBoard: ValidateBoard,
    val validateLocation: ValidateLocation,
    val validateGrade: ValidateGrade,
    val getAllEducationCategoriesUseCase: GetAllEducationCategoryUseCase
)
