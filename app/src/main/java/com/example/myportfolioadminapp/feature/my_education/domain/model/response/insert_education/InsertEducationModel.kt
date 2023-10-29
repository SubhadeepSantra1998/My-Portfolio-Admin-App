package com.example.myportfolioadminapp.feature.my_education.domain.model.response.insert_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.insert_education.InsertEducationDataModel

data class InsertEducationModel(
    val data: InsertEducationDataModel? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)