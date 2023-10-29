package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_skill.data.dto.allSkillsCategory.toDataModel
import com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory.AllSkillsCategoryDataModel
import com.example.myportfolioadminapp.feature.my_skill.domain.repository.MySkillsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetAllSkillsCategoriesUseCase @Inject constructor(
    private val repository: MySkillsRepository
) {

    operator fun invoke(): Flow<Resource<List<AllSkillsCategoryDataModel>>> = flow {
        try {
            emit(Resource.Loading())
            val skills = repository.getAllMySkillsCategories().map { it.toDataModel()}
            emit(Resource.Success(skills))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}