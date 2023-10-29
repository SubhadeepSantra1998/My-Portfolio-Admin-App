package com.example.myportfolioadminapp.feature.my_education.data.dto.insert_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.insert_education.InsertEducationModel

data class InsertEducationDTO(
    val data: InsertEducationDataDTO? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun InsertEducationDTO.toInsertEducationModel(): InsertEducationModel {
    return InsertEducationModel(
        data = data?.toInsertEducationDataModel(),
        errorCode = errorCode,
        message = message,
        success = success
    )
}