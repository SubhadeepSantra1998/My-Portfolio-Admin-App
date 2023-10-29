package com.example.myportfolioadminapp.feature.my_skill.domain.model.get_category

import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_category.AllCategoriesDataModel

data class AllCategoriesModel(
    val data: List<AllCategoriesDataModel>? = null,
    val errorCode: Int? = null,
    val message: String?=null,
    val success: Boolean ? = null
)