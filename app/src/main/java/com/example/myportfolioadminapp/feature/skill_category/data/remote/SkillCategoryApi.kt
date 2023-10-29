package com.example.myportfolioadminapp.feature.skill_category.data.remote

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.skill_category.data.dto.add_category.AddSkillCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.delete_category.DeleteCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.get_all_categories.GetAllSkillCategoriesDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.get_category.GetCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.data.dto.update_category.UpdateCategoryDTO
import com.example.myportfolioadminapp.feature.skill_category.domain.model.request.SkillCategoryRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface SkillCategoryApi {

    @GET(ApiConstants.ALL_SKILL_CATEGORY)
    suspend fun getAllCategories(): GetAllSkillCategoriesDTO


    @POST(ApiConstants.ADD_SKILL_CATEGORY)
    suspend fun addCategory(
        @Body request: SkillCategoryRequest,
    ): AddSkillCategoryDTO


    @DELETE("${ApiConstants.DELETE_SKILL_CATEGORY}/{categoryId}")
    suspend fun deleteCategory(
        @Path("categoryId") categoryId: String
    ): DeleteCategoryDTO?

    @GET("${ApiConstants.MY_SKILL_CATEGORY}/{categoryId}")
    suspend fun getCategory(
        @Path("categoryId") categoryId: String,
    ): GetCategoryDTO?


    @PUT("${ApiConstants.UPDATE_SKILL_CATEGORY}/{categoryId}")
    suspend fun updateCategory(
        @Path("categoryId") categoryId: String,
        @Body request: SkillCategoryRequest,
    ): UpdateCategoryDTO?
}