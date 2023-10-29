package com.example.myportfolioadminapp.feature.education_category.di

import com.example.myportfolioadminapp.common.util.ApiConstants
import com.example.myportfolioadminapp.feature.education_category.data.remote.EducationCategoryApi
import com.example.myportfolioadminapp.feature.education_category.data.repository.EducationCategoryRepositoryImpl
import com.example.myportfolioadminapp.feature.education_category.domain.repository.EducationCategoryRepository
import com.example.myportfolioadminapp.feature.education_category.presentation.viewModel.SharedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EducationCategoryModule {

    @Provides
    @Singleton
    fun providesEducationCategoryApi(): EducationCategoryApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(EducationCategoryApi::class.java)
    }

    @Provides
    @Singleton
    fun providesEducationCategoryRepository(api: EducationCategoryApi): EducationCategoryRepository {
        return EducationCategoryRepositoryImpl(api = api)
    }

    @Provides
    @ViewModelScoped
    fun provideSharedViewModel() = SharedViewModel()

}