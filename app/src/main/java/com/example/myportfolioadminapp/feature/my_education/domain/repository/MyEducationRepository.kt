package com.example.myportfolioadminapp.feature.my_education.domain.repository

import com.example.myportfolioadminapp.feature.my_education.data.dto.delete_education.DeleteEducationDTO
import com.example.myportfolioadminapp.feature.my_education.data.dto.get_all_educations.GetAllEducationsDataDTO


interface MyEducationRepository {

    suspend fun getAllMyEducation(): List<GetAllEducationsDataDTO>?

    suspend fun deleteMyEducation(educationId: String): DeleteEducationDTO
}