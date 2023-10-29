package com.example.myportfolioadminapp.feature.my_education.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject

class ValidateInstitution @Inject constructor() {

    operator fun invoke(institution: String): ValidationResultModel {
        if (institution.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.institution_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}