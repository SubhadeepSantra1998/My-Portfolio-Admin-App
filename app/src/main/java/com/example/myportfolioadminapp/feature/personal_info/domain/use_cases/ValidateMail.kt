package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject


class ValidateMail @Inject constructor() {

    operator fun invoke(mail: String): ValidationResultModel {
        if (mail.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.mail_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}