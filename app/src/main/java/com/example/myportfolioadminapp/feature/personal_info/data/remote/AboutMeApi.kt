package com.example.myportfolioadminapp.feature.personal_info.data.remote

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.personal_info.data.remote.request.PersonalInfoRequest
import com.example.myportfolioadminapp.feature.personal_info.data.remote.response.AboutMeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import javax.inject.Inject



class AboutMeApi @Inject constructor(private val client: HttpClient) {

    suspend fun insertAboutMe(personalInfoRequest: PersonalInfoRequest): AboutMeResponse {
        return client.post(ApiConstants.LOGIN) {
            setBody(personalInfoRequest)
        }.body()
    }
}