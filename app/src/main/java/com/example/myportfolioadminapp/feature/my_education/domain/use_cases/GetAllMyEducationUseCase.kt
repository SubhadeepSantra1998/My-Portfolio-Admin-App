package com.example.myportfolioadminapp.feature.my_education.domain.use_cases

import com.example.myportfolioadminapp.common.util.Resource
import com.example.myportfolioadminapp.feature.my_education.data.dto.get_all_educations.toGetAllEducationsDataModel
import com.example.myportfolioadminapp.feature.my_education.data.remote.MyEducationApi
import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.GetAllEducationsDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject




class GetAllMyEducationUseCase @Inject constructor(
    private val repository: MyEducationApi
) {

    operator fun invoke(): Flow<Resource<List<GetAllEducationsDataModel>>> = flow {
        try {
            emit(Resource.Loading())
            val educations = repository.getAllMyEducations().data?.map { it.toGetAllEducationsDataModel() }
            emit(Resource.Success(educations))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server."))
        }
    }

}