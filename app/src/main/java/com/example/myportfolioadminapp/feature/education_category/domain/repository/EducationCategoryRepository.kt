package com.example.myportfolioadminapp.feature.education_category.domain.repository

import com.example.myportfolioadminapp.feature.education_category.data.dto.add_education_category.AddEducationCategoryDataDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.delete_education_category.DeleteCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.get_all_education_category.AllEducationCategoryDataDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.get_education_category.GetCategoryDataDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.update_education_category.UpdateEducationCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.domain.model.request.EducationCategoryRequest

interface EducationCategoryRepository {

    suspend fun getAllEducationCategories(): List<AllEducationCategoryDataDTO>?

    suspend fun insertCategory(request: EducationCategoryRequest): AddEducationCategoryDataDTO?

    suspend fun deleteCategory(categoryId: String): DeleteCategoryDTO?

    suspend fun updateCategory(categoryId: String, request: EducationCategoryRequest): UpdateEducationCategoryDTO?

    suspend fun getCategory(categoryId: String): GetCategoryDataDTO?

}