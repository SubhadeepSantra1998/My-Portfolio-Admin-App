package com.example.myportfolioadminapp.feature.my_skill.domain.model.get_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.get_skill.GetSkillDataModel

data class GetSkillModel(
    val data: GetSkillDataModel? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)