package com.example.myportfolioadminapp.feature.my_skill.data.dto.get_categories

import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_category.AllCategoriesDataModel

data class AllCategoriesDataDTO(
    val createdAt: Long,
    val description: String,
    val id: String,
    val skill: Any ? = null,
    val status: Int,
    val title: String,
    val updatedAt: Long
)

fun AllCategoriesDataDTO.toDataModel(): AllCategoriesDataModel {
    return AllCategoriesDataModel(
        id = id,
        title = title
    )
}