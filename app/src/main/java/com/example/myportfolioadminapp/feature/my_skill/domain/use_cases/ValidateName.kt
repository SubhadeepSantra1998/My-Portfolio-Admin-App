package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject

class ValidateName @Inject constructor() {

    operator fun invoke(name: String): ValidationResultModel {
        if (name.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.name_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}