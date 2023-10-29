package com.example.myportfolioadminapp.feature.skill_category.domain.use_cases

import com.example.myportfolioadminapp.feature.skill_category.domain.use_cases.DeleteCategoryUseCase
import com.example.myportfolioadminapp.feature.skill_category.domain.use_cases.GetAllSkillCategoryUseCase
import javax.inject.Inject

data class SkillCategoriesUseCases @Inject constructor(
    val categoriesUseCase: GetAllSkillCategoryUseCase,
    val deleteCategoryUseCase: DeleteCategoryUseCase
)