package com.example.myportfolioadminapp.feature.my_education.data.dto.get_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_education.GetEducationDataModel

data class GetEducationDataDTO(
    val board: String,
    val categoryId: String,
    val course: String? = null,
    val createdAt: Long,
    val grade: String,
    val id: String,
    val institution: String,
    val location: String,
    val status: Int,
    val updatedAt: Long
)

fun GetEducationDataDTO.toGetEducationDataModel(): GetEducationDataModel {
    return GetEducationDataModel(
        board = board,
        categoryId = categoryId,
        course = course,
        grade = grade,
        id = id,
        institution = institution,
        location = location,
        status = status
    )
}