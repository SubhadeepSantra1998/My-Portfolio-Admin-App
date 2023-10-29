package com.example.myportfolioadminapp.feature.my_education.data.dto.get_all_educations

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.GetAllEducationsModel

data class GetAllEducationsDTO(
    val data: List<GetAllEducationsDataDTO>? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun GetAllEducationsDTO.toGetAllEducationsModel(): GetAllEducationsModel {
    return GetAllEducationsModel(
        data = data?.map { it.toGetAllEducationsDataModel() },
        errorCode = errorCode,
        message = message,
        success = success
    )
}