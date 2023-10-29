package com.example.myportfolioadminapp.feature.education_category.data.remote

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.education_category.data.dto.add_education_category.AddEducationCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.delete_education_category.DeleteCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.get_all_education_category.AllEducationCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.get_education_category.GetCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.data.dto.update_education_category.UpdateEducationCategoryDTO
import com.example.myportfolioadminapp.feature.education_category.domain.model.request.EducationCategoryRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EducationCategoryApi {

    @GET(ApiConstants.ALL_EDUCATION_CATEGORY)
    suspend fun getAllEducationCategories(): AllEducationCategoryDTO


    @POST(ApiConstants.ADD_EDUCATION_CATEGORY)
    suspend fun insertEducationCategory(
        @Body request: EducationCategoryRequest,
    ): AddEducationCategoryDTO?


    @DELETE("${ApiConstants.DELETE_EDUCATION_CATEGORY}/{categoryId}")
    suspend fun deleteCategory(
        @Path("categoryId") categoryId: String
    ): DeleteCategoryDTO?


    @GET("${ApiConstants.MY_EDUCATION_CATEGORY}/{categoryId}")
    suspend fun getCategory(
        @Path("categoryId") categoryId: String,
    ): GetCategoryDTO?

    @PUT("${ApiConstants.UPDATE_EDUCATION_CATEGORY}/{categoryId}")
    suspend fun updateSkill(
        @Path("categoryId") categoryId: String,
        @Body request: EducationCategoryRequest,
    ): UpdateEducationCategoryDTO?
}