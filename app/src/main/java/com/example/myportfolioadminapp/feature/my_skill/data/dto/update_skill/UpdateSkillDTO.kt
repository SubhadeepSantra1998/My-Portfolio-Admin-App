package com.example.myportfolioadminapp.feature.my_skill.data.dto.update_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.update_skill.UpdateSkillModel

data class UpdateSkillDTO(
    val data: Any,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun UpdateSkillDTO.toUpdateSkillModel(): UpdateSkillModel {
    return UpdateSkillModel(
        errorCode = errorCode,
        message = message
    )
}