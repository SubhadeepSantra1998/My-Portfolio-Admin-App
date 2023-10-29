package com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_education.GetEducationDataModel

data class GetEducationModel(
    val data: GetEducationDataModel? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)