package com.example.myportfolioadminapp.feature.skill_category.domain.repository

import com.example.myportfolioadminapp.feature.skill_category.data.dto.add_category.AddSkillCategoryDataDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.delete_category.DeleteCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.get_all_categories.DataDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.get_category.GetCategoryDataDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.update_category.UpdateCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.domain.model.request.SkillCategoryRequest

interface SkillCategoryRepository {

    suspend fun getAllSkillCategories(): List<DataDTO>?

    suspend fun addCategory(request: SkillCategoryRequest): AddSkillCategoryDataDTO?

    suspend fun deleteCategory(categoryId: String): DeleteCategoryDTO?

    suspend fun getCategory(categoryId: String): GetCategoryDataDTO?

    suspend fun updateCategory(categoryId: String, request: SkillCategoryRequest): UpdateCategoryDTO?
}