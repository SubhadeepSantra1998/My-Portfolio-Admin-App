package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject


class ValidatePhNo @Inject constructor() {

    operator fun invoke(phNo: String): ValidationResultModel {
        if (phNo.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.phNo_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}