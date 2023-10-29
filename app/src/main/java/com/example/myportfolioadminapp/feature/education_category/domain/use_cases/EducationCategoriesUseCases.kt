package com.example.myportfolioadminapp.feature.education_category.domain.use_cases


import javax.inject.Inject

data class EducationCategoriesUseCases @Inject constructor(
    val categoriesUseCase: GetAllEducationCategoryUseCase,
    val validateTitle: ValidateTitle,
    val validateDescription: ValidateDescription,
    val saveCategory: InsertEducationCategoryUseCase,
    val deleteCategory: DeleteEducationCategoryUseCase
)