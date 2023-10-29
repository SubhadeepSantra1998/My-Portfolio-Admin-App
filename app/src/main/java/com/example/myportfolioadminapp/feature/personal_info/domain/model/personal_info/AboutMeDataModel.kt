package com.example.myportfolioadminapp.feature.personal_info.domain.model.personal_info

data class AboutMeDataModel(
    val id: String,
    val name: String,
    val designation: String,
    val title: String,
    val description: String,
    val dob: Long,
    val location: String,
    val mail: String,
    val phNo: String,
    val githubUrl: String,
    val linkedinUrl: String,
    val playStoreUrl: String,
    val createdAt: Long,
    val updatedAt: Long
)
