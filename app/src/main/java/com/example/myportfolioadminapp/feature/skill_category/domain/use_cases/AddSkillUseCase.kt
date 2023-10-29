package com.example.myportfolioadminapp.feature.skill_category.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.skill_category.data.dto.add_category.toDataModel
import com.example.myportfolioadminapp.feature.skill_category.domain.model.request.SkillCategoryRequest
import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.add_category.DataModel
import com.example.myportfolioadminapp.feature.skill_category.domain.repository.SkillCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class AddSkillUseCase @Inject constructor(
    private val repository: SkillCategoryRepository
) {

    operator fun invoke(request: SkillCategoryRequest): Flow<Resource<DataModel>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.addCategory(request)?.toDataModel()
            emit(Resource.Success(response))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}