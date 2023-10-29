package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject


class ValidateLinkedinUrl @Inject constructor() {

    operator fun invoke(linkedinUrl: String): ValidationResultModel {
        if (linkedinUrl.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.linkedin_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}