package com.example.myportfolioadminapp.feature.my_skill.data.dto.delete_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.delete_skill.DeleteSkillModel

data class DeleteSkillDTO(
    val data: Any,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun DeleteSkillDTO.toDeleteSkillModel(): DeleteSkillModel {
    return DeleteSkillModel(
        errorCode = errorCode,
        message = message
    )
}