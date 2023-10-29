package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_skill.data.dto.get_skill.toGetSkillDataModel
import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_skill.GetSkillDataModel
import com.example.myportfolioadminapp.feature.my_skill.domain.repository.MySkillsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetSkillBySkillIdUseCase @Inject constructor(
    private val repository: MySkillsRepository
) {

    operator fun invoke(skillId: String): Flow<Resource<GetSkillDataModel>> = flow {
        try {
            emit(Resource.Loading())
            val skills = repository.getSkill(skillId)?.toGetSkillDataModel()
            emit(Resource.Success(skills))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}