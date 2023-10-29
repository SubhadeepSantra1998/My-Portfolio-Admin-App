package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject

class ValidateName @Inject constructor() {

    operator fun invoke(email: String): ValidationResultModel {
        if (email.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.name_field_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}