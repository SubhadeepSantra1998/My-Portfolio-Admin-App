package com.example.myportfolioadminapp.feature.education_category.domain.model.request

import kotlinx.serialization.Serializable

@Serializable
data class EducationCategoryRequest(
    val title: String,
    val description: String,
    val status: Int
)
