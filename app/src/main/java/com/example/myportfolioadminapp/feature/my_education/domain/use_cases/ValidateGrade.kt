package com.example.myportfolioadminapp.feature.my_education.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel

import javax.inject.Inject

class ValidateGrade @Inject constructor() {

    operator fun invoke(grade: String): ValidationResultModel {
        if (grade.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.grade_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}