package com.example.myportfolioadminapp.feature.education_category.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject

class ValidateDescription @Inject constructor() {

    operator fun invoke(description: String): ValidationResultModel {
        if (description.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.description_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}