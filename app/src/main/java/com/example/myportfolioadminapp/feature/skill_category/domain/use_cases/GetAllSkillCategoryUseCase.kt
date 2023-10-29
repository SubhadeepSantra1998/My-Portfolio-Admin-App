package com.example.myportfolioadminapp.feature.skill_category.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.skill_category.data.dto.get_all_categories.toDataModel
import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_all_categories.DataModel
import com.example.myportfolioadminapp.feature.skill_category.domain.repository.SkillCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetAllSkillCategoryUseCase @Inject constructor(
    private val repository: SkillCategoryRepository
) {

    operator fun invoke(): Flow<Resource<List<DataModel>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = repository.getAllSkillCategories()?.map { it.toDataModel()}
            emit(Resource.Success(categories))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}