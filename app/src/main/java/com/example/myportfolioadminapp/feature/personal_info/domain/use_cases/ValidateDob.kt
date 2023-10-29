package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject


class ValidateDob @Inject constructor() {

    operator fun invoke(dob: Long): ValidationResultModel {
        if (dob.toString().isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.dob_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}