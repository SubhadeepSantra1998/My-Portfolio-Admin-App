package com.example.myportfolioadminapp.feature.my_education.domain.model.response.insert_education

data class InsertEducationDataModel(
    val board: String,
    val categoryId: String,
    val course: String? = null,
    val grade: String,
    val id: String,
    val institution: String,
    val location: String,
    val status: Int
)