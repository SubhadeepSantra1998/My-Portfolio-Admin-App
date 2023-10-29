package com.example.myportfolioadminapp.feature.my_skill.data.dto.get_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_skill.GetSkillModel

data class GetSkillDTO(
    val data: GetSkillDataDTO? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun GetSkillDTO.toGetSkillModel(): GetSkillModel {
    return GetSkillModel(
        data = data?.toGetSkillDataModel(),
        errorCode = errorCode,
        message = message,
        success = success
    )
}