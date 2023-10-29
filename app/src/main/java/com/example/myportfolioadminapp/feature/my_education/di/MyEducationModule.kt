package com.example.myportfolioadminapp.feature.my_education.di

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.my_education.data.remote.MyEducationApi
import com.example.myportfolioadminapp.feature.my_education.data.repository.MyEducationRepositoryImpl
import com.example.myportfolioadminapp.feature.my_education.domain.repository.MyEducationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MyEducationModule {

    @Provides
    @Singleton
    fun providesMyEducationApi(): MyEducationApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MyEducationApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMyEducationRepository(api: MyEducationApi): MyEducationRepository {
        return MyEducationRepositoryImpl(api = api)
    }
}