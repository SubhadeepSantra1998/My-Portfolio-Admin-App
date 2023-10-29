package com.example.myportfolioadminapp.feature.education_category.domain.use_cases

import javax.inject.Inject


data class UpdateEducationCategoryUseCases @Inject constructor(
    val getEducationCategoryUseCase: GetEducationCategoryUseCase,
    val updateCategoryUseCase: UpdateCategoryUseCase,
    val validateTitle: ValidateTitle,
    val validateDescription: ValidateDescription,
//    val saveCategory: InsertEducationCategoryUseCase,
//    val deleteCategory: DeleteEducationCategoryUseCase
)