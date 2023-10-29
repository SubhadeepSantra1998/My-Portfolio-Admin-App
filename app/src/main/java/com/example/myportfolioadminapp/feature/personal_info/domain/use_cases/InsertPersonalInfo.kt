package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases


//class InsertPersonalInfo @Inject constructor(
//    private val repository: PersonalInfoRepo,
//) {
//    operator fun invoke(personalInfoRequest: PersonalInfoRequest): Flow<Resource<AboutMe>> = flow {
//        try {
//            val result = repository.insertInfo(personalInfoRequest)
//
//            if (result.success) emit(Resource.Success(result))
//            else emit(Resource.Error(result.message))
//
//        } catch (e: Exception) {
//            emit(Resource.Error(e.localizedMessage!!))
//        }
//    }
//}