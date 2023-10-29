package com.example.myportfolioadminapp.feature.personal_info.domain.model.personal_info


data class AboutMe(
    val success: Boolean,
    val message: String,
    val errorCode: Int?,
    val data: AboutMeDataModel?,
)