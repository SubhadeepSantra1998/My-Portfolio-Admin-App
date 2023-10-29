package com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations

data class EducationModel(
    val board: String,
    val categoryId: String,
    val course: String? = null,
    val grade: String,
    val id: String,
    val institution: String,
    val location: String,
    val status: Int,
)