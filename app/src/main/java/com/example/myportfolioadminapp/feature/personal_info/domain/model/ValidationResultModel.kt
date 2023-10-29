package com.example.myportfolioadminapp.feature.personal_info.domain.model

data class ValidationResultModel(
    val isSuccess: Boolean,
    val errorMessage: Int? = null
)