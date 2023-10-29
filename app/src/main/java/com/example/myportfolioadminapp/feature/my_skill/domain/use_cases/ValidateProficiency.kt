package com.example.myportfolioadminapp.feature.my_skill.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject

class ValidateProficiency @Inject constructor() {

    operator fun invoke(proficiency: Float): ValidationResultModel {
        if (proficiency == 0f) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.proficiency_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}