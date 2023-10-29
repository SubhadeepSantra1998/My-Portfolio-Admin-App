package com.example.myportfolioadminapp.feature.my_education.data.dto.get_all_educations

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.GetAllEducationsDataModel

data class GetAllEducationsDataDTO(
    val createdAt: Long,
    val description: String,
    val education: List<EducationDTO>? = null,
    val id: String,
    val status: Int,
    val title: String,
    val updatedAt: Long
)

fun GetAllEducationsDataDTO.toGetAllEducationsDataModel(): GetAllEducationsDataModel {
    return GetAllEducationsDataModel(
        description = description,
        education = education?.map { it.toEducationModel() },
        id = id,
        status = status,
        title = title
    )
}