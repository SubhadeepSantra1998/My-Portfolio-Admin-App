package com.example.myportfolioadminapp.feature.education_category.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.education_category.data.dto.update_education_category.toUpdateEducationCategoryModel
import com.example.myportfolioadminapp.feature.education_category.domain.model.request.EducationCategoryRequest
import com.example.myportfolioadminapp.feature.education_category.domain.model.update_education_category.UpdateEducationCategoryModel
import com.example.myportfolioadminapp.feature.education_category.domain.repository.EducationCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class UpdateCategoryUseCase @Inject constructor(
    private val repository: EducationCategoryRepository
) {

    operator fun invoke(categoryId: String, request: EducationCategoryRequest): Flow<Resource<UpdateEducationCategoryModel>> = flow {
        try {
            emit(Resource.Loading())
            val category = repository.updateCategory(categoryId, request)?.toUpdateEducationCategoryModel()
            emit(Resource.Success(category))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}