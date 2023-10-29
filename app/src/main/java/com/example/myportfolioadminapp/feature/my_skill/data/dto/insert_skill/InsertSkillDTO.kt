package com.example.myportfolioadminapp.feature.my_skill.data.dto.insert_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.insert_skill.InsertSkillModel

data class InsertSkillDTO(
    val data: InsertSkillDataDTO? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)

fun InsertSkillDTO.toInsertSkillModel(): InsertSkillModel {
    return InsertSkillModel(
        data = data?.toInsertSkillDataModel(),
        errorCode = errorCode,
        message = message,
        success = success
    )
}