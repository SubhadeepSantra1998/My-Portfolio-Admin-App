package com.example.myportfolioadminapp.feature.personal_info.data.remote.response

import com.example.myportfolioadminapp.feature.personal_info.domain.model.personal_info.AboutMe
import kotlinx.serialization.Serializable


@Serializable
data class AboutMeResponse(
    val success: Boolean,
    val message: String,
    val errorCode: Int?,
    val data: AboutMeDataModelResponse?,
){
    fun toAboutMeModel(): AboutMe {
        return AboutMe(
            success = success,
            message = message,
            errorCode = errorCode,
            data = data?.toAboutMeDataModel(),
        )
    }
}
