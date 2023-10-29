package com.example.myportfolioadminapp.feature.skill_category.data.repository

import com.example.myportfolioadminapp.feature.skill_category.data.dto.add_category.AddSkillCategoryDataDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.delete_category.DeleteCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.get_all_categories.DataDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.get_category.GetCategoryDataDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.update_category.UpdateCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.data.remote.SkillCategoryApi
import com.example.myportfolioadminapp.feature.skill_category.domain.model.request.SkillCategoryRequest
import com.example.myportfolioadminapp.feature.skill_category.domain.repository.SkillCategoryRepository
import javax.inject.Inject



class SkillCategoryRepositoryImpl @Inject constructor(
    private val api: SkillCategoryApi
): SkillCategoryRepository {

    override suspend fun getAllSkillCategories(): List<DataDTO>? {
        return api.getAllCategories().data
    }

    override suspend fun addCategory(request: SkillCategoryRequest): AddSkillCategoryDataDTO? {
        return api.addCategory(request).data
    }

    override suspend fun deleteCategory(categoryId: String): DeleteCategoryDTO? {
        return api.deleteCategory(categoryId)
    }

    override suspend fun getCategory(categoryId: String): GetCategoryDataDTO? {
        return api.getCategory(categoryId)?.data
    }

    override suspend fun updateCategory(
        categoryId: String,
        request: SkillCategoryRequest
    ): UpdateCategoryDTO? {
        return api.updateCategory(categoryId, request)
    }

}