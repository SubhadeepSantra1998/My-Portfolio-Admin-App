package com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_category

data class GetCategoryDataModel(
    val description: String,
    val id: String,
    val status: Int,
    val title: String
)