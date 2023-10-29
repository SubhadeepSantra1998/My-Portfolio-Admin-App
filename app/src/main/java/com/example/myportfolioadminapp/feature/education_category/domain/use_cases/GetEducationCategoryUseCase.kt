package com.example.myportfolioadminapp.feature.education_category.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.education_category.data.dto.get_education_category.toGetCategoryDataModel
import com.example.myportfolioadminapp.feature.education_category.domain.model.get_education_category.GetCategoryDataModel
import com.example.myportfolioadminapp.feature.education_category.domain.repository.EducationCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetEducationCategoryUseCase @Inject constructor(
    private val repository: EducationCategoryRepository
) {

    operator fun invoke(categoryId: String): Flow<Resource<GetCategoryDataModel>> = flow {
        try {
            emit(Resource.Loading())
            val categories = repository.getCategory(categoryId)?.toGetCategoryDataModel()
            emit(Resource.Success(categories))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}
