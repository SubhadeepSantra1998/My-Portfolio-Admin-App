package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import javax.inject.Inject

data class PersonalInfoUseCase @Inject constructor(
    val validateName: ValidateName,
    val validateDesignation: ValidateDesignation,
    val validateTitle: ValidateTitle,
    val validateDescription: ValidateDescription,
    val validateDob: ValidateDob,
    val validateLocation: ValidateLocation,
    val validateMail: ValidateMail,
    val validatePhNo: ValidatePhNo,
    val validateGithubUrl: ValidateGithubUrl,
    val validateLinkedinUrl: ValidateLinkedinUrl,
    val validatePlaystoreUrl: ValidatePlaystoreUrl,
    //val insertPersonalInfo: InsertPersonalInfo,
)