package com.example.myportfolioadminapp.feature.my_education.data.remote

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.my_education.data.dto.delete_education.DeleteEducationDTO
import com.example.myportfolioadminapp.feature.my_education.data.dto.get_all_educations.GetAllEducationsDTO
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface MyEducationApi {

    @GET(ApiConstants.ALL_MY_EDUCATION)
    suspend fun getAllMyEducations(): GetAllEducationsDTO

    @DELETE("${ApiConstants.DELETE_MY_EDUCATION}/{educationId}")
    suspend fun deleteMyEducation(
        @Path("educationId") educationId: String
    ): DeleteEducationDTO
}