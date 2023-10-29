package com.example.myportfolioadminapp.feature.skill_category.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.skill_category.data.dto.delete_category.toDeleteCategoryModel
import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.delete_category.DeleteCategoryModel
import com.example.myportfolioadminapp.feature.skill_category.domain.repository.SkillCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class DeleteCategoryUseCase @Inject constructor(
    private val repository: SkillCategoryRepository
) {

    operator fun invoke(categoryId: String): Flow<Resource<DeleteCategoryModel>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.deleteCategory(categoryId)?.toDeleteCategoryModel()
            emit(Resource.Success(response))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }
}