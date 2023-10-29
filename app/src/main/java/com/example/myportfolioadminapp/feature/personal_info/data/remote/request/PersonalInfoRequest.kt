package com.example.myportfolioadminapp.feature.personal_info.data.remote.request

import kotlinx.serialization.Serializable


@Serializable
data class PersonalInfoRequest(
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
    val playStoreUrl: String
)
