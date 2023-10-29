package com.example.myportfolioadminapp.feature.my_education.data.dto.insert_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.insert_education.InsertEducationDataModel

data class InsertEducationDataDTO(
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

fun InsertEducationDataDTO.toInsertEducationDataModel(): InsertEducationDataModel {
    return InsertEducationDataModel(
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