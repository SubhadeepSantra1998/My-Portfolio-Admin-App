package com.example.myportfolioadminapp.feature.education_category.data.repository

import com.example.myportfolioadminapp.feature.education_category.data.dto.add_education_category.AddEducationCategoryDataDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.delete_education_category.DeleteCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.get_all_education_category.AllEducationCategoryDataDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.get_education_category.GetCategoryDataDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.update_education_category.UpdateEducationCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.data.remote.EducationCategoryApi
import com.example.myportfolioadminapp.feature.education_category.domain.model.request.EducationCategoryRequest
import com.example.myportfolioadminapp.feature.education_category.domain.repository.EducationCategoryRepository
import javax.inject.Inject



class EducationCategoryRepositoryImpl @Inject constructor(
    private val api: EducationCategoryApi
): EducationCategoryRepository {

    override suspend fun getAllEducationCategories(): List<AllEducationCategoryDataDTO>? {
        return api.getAllEducationCategories().data
    }

    override suspend fun insertCategory(request: EducationCategoryRequest): AddEducationCategoryDataDTO? {
        return api.insertEducationCategory(request)?.data
    }

    override suspend fun deleteCategory(categoryId: String): DeleteCategoryDTO? {
        return api.deleteCategory(categoryId)
    }

    override suspend fun updateCategory(
        categoryId: String,
        request: EducationCategoryRequest
    ): UpdateEducationCategoryDTO? {
        return api.updateSkill(categoryId, request)
    }

    override suspend fun getCategory(categoryId: String): GetCategoryDataDTO? {
        return api.getCategory(categoryId)?.data
    }

}