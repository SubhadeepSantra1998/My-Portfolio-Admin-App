package com.example.myportfolioadminapp.feature.personal_info.data.remote.response

import com.example.myportfolioadminapp.feature.personal_info.domain.model.personal_info.AboutMeDataModel
import kotlinx.serialization.Serializable

@Serializable
data class AboutMeDataModelResponse(
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
){
    fun toAboutMeDataModel(): AboutMeDataModel {
        return AboutMeDataModel(
            id = id,
            name = name,
            designation = designation,
            title = title,
            description = description,
            dob = dob,
            location = location,
            mail = mail,
            phNo = phNo,
            githubUrl = githubUrl,
            linkedinUrl = linkedinUrl,
            playStoreUrl = playStoreUrl,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}
