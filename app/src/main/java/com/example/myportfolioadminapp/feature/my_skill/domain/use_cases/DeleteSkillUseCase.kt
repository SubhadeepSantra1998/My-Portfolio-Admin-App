package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_skill.data.dto.delete_skill.toDeleteSkillModel
import com.example.myportfolioadminapp.feature.my_skill.domain.model.delete_skill.DeleteSkillModel
import com.example.myportfolioadminapp.feature.my_skill.domain.repository.MySkillsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class DeleteSkillUseCase @Inject constructor(
    private val repository: MySkillsRepository
) {

    operator fun invoke(skillId: String): Flow<Resource<DeleteSkillModel>> = flow {
        try {
            emit(Resource.Loading())
            val skill = repository.deleteSkill(skillId)?.toDeleteSkillModel()
            emit(Resource.Success(skill))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}