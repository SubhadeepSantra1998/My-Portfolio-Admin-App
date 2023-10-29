package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject


class ValidateGithubUrl @Inject constructor() {

    operator fun invoke(githubUrl: String): ValidationResultModel {
        if (githubUrl.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.github_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}