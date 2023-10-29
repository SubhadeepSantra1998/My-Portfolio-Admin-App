package com.example.myportfolioadminapp.feature.personal_info.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject


class ValidatePlaystoreUrl @Inject constructor() {

    operator fun invoke(playStoreUrl: String): ValidationResultModel {
        if (playStoreUrl.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.playStore_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}