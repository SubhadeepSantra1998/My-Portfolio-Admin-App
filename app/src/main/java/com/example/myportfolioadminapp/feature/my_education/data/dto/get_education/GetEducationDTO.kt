package com.example.myportfolioadminapp.feature.my_education.data.dto.get_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_education.GetEducationModel

data class GetEducationDTO(
    val data: GetEducationDataDTO? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun GetEducationDTO.toGetEducationModel(): GetEducationModel {
    return GetEducationModel(
        data = data?.toGetEducationDataModel(),
        errorCode = errorCode,
        message = message,
        success = success
    )
}