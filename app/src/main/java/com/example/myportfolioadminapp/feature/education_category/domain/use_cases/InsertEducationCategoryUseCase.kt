package com.example.myportfolioadminapp.feature.education_category.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.education_category.data.dto.add_education_category.toAddEducationCategoryDataModel
import com.example.myportfolioadminapp.feature.education_category.domain.model.add_education_category.AddEducationCategoryDataModel
import com.example.myportfolioadminapp.feature.education_category.domain.model.request.EducationCategoryRequest
import com.example.myportfolioadminapp.feature.education_category.domain.repository.EducationCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject



class InsertEducationCategoryUseCase @Inject constructor(
    private val repository: EducationCategoryRepository
) {

    operator fun invoke(request: EducationCategoryRequest): Flow<Resource<AddEducationCategoryDataModel>> = flow {
        try {
            emit(Resource.Loading())
            val category = repository.insertCategory(request)?.toAddEducationCategoryDataModel()
            emit(Resource.Success(category))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}
