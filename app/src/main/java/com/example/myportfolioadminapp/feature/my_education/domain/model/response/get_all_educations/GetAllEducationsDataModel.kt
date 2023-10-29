package com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.EducationModel

data class GetAllEducationsDataModel(
    val description: String,
    val education: List<EducationModel>? = null,
    val id: String,
    val status: Int,
    val title: String
)