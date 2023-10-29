package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject

class ValidateDesignation @Inject constructor() {

    operator fun invoke(designation: String): ValidationResultModel {
        if (designation.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.designation_field_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}