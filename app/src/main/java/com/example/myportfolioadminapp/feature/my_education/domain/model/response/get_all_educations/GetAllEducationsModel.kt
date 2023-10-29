package com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.GetAllEducationsDataModel

data class GetAllEducationsModel(
    val data: List<GetAllEducationsDataModel>? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)