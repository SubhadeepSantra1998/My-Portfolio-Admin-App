package com.example.myportfolioadminapp.feature.my_skill.data.dto.get_categories

import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_category.AllCategoriesModel

data class AllCategoriesDTO(
    val data: List<AllCategoriesDataDTO>? = null,
    val errorCode: Int? = null,
    val message: String?=null,
    val success: Boolean ? = null
)

fun AllCategoriesDTO.toAllCategoriesModel() : AllCategoriesModel {
    return AllCategoriesModel(
        data = data?.map { it.toDataModel() },
        errorCode = errorCode,
        message = message,
        success = success
    )
}