package com.example.myportfolioadminapp.feature.my_skill.data.remote

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.my_skill.data.dto.allSkillsCategory.AllSkillCategoryDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.delete_skill.DeleteSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.get_categories.AllCategoriesDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.get_skill.GetSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.insert_skill.InsertSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.update_skill.UpdateSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.domain.model.request.SkillRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MySkillsApi {

    @GET(ApiConstants.MY_SKILL_ALL)
    suspend fun getAllMySkillsCategories(): AllSkillCategoryDTO


    @GET(ApiConstants.MY_SKILL_CATEGORY)
    suspend fun getAllCategories(): AllCategoriesDTO?


    @POST("${ApiConstants.ADD_MY_SKILL}/{categoryId}")
    suspend fun insertSkill(
        @Path("categoryId") categoryId: String,
        @Body request: SkillRequest,
    ): InsertSkillDTO?


    @GET("${ApiConstants.MY_SKILL}/{skillId}")
    suspend fun getSkill(
        @Path("skillId") skillId: String,
    ): GetSkillDTO?


    @PUT("${ApiConstants.UPDATE_MY_SKILL}/{skillId}")
    suspend fun updateSkill(
        @Path("skillId") skillId: String,
        @Body request: SkillRequest,
    ): UpdateSkillDTO?


    @DELETE("${ApiConstants.DELETE_MY_SKILL}/{skillId}")
    suspend fun deleteSkill(
        @Path("skillId") skillId: String
    ): DeleteSkillDTO?

}