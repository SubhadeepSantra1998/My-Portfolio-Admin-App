package com.example.myportfolioadminapp.feature.my_education.data.repository

import com.example.myportfolioadminapp.feature.my_education.data.dto.delete_education.DeleteEducationDTO
import com.example.myportfolioadminapp.feature.my_education.data.dto.get_all_educations.GetAllEducationsDataDTO
import com.example.myportfolioadminapp.feature.my_education.data.remote.MyEducationApi
import com.example.myportfolioadminapp.feature.my_education.domain.repository.MyEducationRepository
import javax.inject.Inject



class MyEducationRepositoryImpl @Inject constructor(
    private val api: MyEducationApi
): MyEducationRepository {
    override suspend fun getAllMyEducation(): List<GetAllEducationsDataDTO>? {
        return api.getAllMyEducations().data
    }

    override suspend fun deleteMyEducation(educationId: String): DeleteEducationDTO {
        return api.deleteMyEducation(educationId)
    }

}