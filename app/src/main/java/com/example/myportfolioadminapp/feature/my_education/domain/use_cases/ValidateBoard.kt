package com.example.myportfolioadminapp.feature.my_education.domain.use_cases

import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.personal_info.domain.model.ValidationResultModel
import javax.inject.Inject

class ValidateBoard @Inject constructor() {

    operator fun invoke(board: String): ValidationResultModel {
        if (board.isBlank()) {
            return ValidationResultModel(
                isSuccess = false,
                errorMessage = R.string.board_filed_is_required
            )
        }

        return ValidationResultModel(
            isSuccess = true
        )
    }

}