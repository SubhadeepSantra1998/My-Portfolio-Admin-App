package com.example.myportfolioadminapp.feature.my_education.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_education.data.dto.delete_education.toDeleteEducationModel
import com.example.myportfolioadminapp.feature.my_education.domain.model.response.delete_education.DeleteEducationModel
import com.example.myportfolioadminapp.feature.my_education.domain.repository.MyEducationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class DeleteMyEducationUseCase @Inject constructor(
    private val repository: MyEducationRepository
) {

    operator fun invoke(educationId: String): Flow<Resource<DeleteEducationModel>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.deleteMyEducation(educationId).toDeleteEducationModel()
            emit(Resource.Success(response))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }
}