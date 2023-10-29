package com.example.myportfolioadminapp.feature.my_education.data.dto.delete_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.delete_education.DeleteEducationModel


data class DeleteEducationDTO(
    val data: Any,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun DeleteEducationDTO.toDeleteEducationModel(): DeleteEducationModel {
    return DeleteEducationModel(
        errorCode = errorCode,
        message = message
    )
}