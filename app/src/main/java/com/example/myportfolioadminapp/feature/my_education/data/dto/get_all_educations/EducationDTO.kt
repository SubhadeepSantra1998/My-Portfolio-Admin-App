package com.example.myportfolioadminapp.feature.my_education.data.dto.get_all_educations

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.EducationModel

data class EducationDTO(
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

fun EducationDTO.toEducationModel(): EducationModel {
    return EducationModel(
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