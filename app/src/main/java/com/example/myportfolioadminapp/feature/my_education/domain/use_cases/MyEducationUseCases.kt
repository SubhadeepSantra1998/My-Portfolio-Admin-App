package com.example.myportfolioadminapp.feature.my_education.domain.use_cases

import com.example.myportfolioadminapp.feature.my_education.domain.use_cases.DeleteMyEducationUseCase
import com.example.myportfolioadminapp.feature.my_education.domain.use_cases.GetAllMyEducationUseCase
import javax.inject.Inject



data class MyEducationUseCases @Inject constructor(
    val getAllMyEducationUseCase: GetAllMyEducationUseCase,
    val deleteMyEducationUseCase: DeleteMyEducationUseCase
)