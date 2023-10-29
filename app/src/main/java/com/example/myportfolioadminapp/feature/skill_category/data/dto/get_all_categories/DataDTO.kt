package com.example.myportfolioadminapp.feature.skill_category.data.dto.get_all_categories

import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_all_categories.DataModel

data class DataDTO(
    val createdAt: Long,
    val description: String,
    val id: String,
    val skill: Any,
    val status: Int,
    val title: String,
    val updatedAt: Long
)

fun DataDTO.toDataModel(): DataModel {
    return DataModel(
        description = description,
        id = id,
        status = status,
        title = title
    )
}