package com.example.myportfolioadminapp.feature.skill_category.di

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.skill_category.data.remote.SkillCategoryApi
import com.example.myportfolioadminapp.feature.skill_category.data.repository.SkillCategoryRepositoryImpl
import com.example.myportfolioadminapp.feature.skill_category.domain.repository.SkillCategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object SkillCategoryModule {

    @Provides
    @Singleton
    fun providesSkillCategoryApi(): SkillCategoryApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(SkillCategoryApi::class.java)
    }

    @Provides
    @Singleton
    fun providesSkillCategoryRepository(api: SkillCategoryApi): SkillCategoryRepository {
        return SkillCategoryRepositoryImpl(api = api)
    }
}