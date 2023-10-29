package com.example.myportfolioadminapp.feature.my_skill.di

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.my_skill.data.remote.MySkillsApi
import com.example.myportfolioadminapp.feature.my_skill.data.repository.MySkillsRepositoryImpl
import com.example.myportfolioadminapp.feature.my_skill.domain.repository.MySkillsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MySkillsModule {

    @Provides
    @Singleton
    fun providesMySkillApi(): MySkillsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MySkillsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMySkillsRepository(api: MySkillsApi): MySkillsRepository {
        return MySkillsRepositoryImpl(api = api)
    }
}