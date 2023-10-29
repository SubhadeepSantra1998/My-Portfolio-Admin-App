package com.example.myportfolioadminapp.feature.my_skill.domain.model.insert_skill

import com.example.myportfolioadminapp.feature.my_skill.domain.model.insert_skill.InsertSkillDataModel

data class InsertSkillModel(
    val data: InsertSkillDataModel? = null,
    val errorCode: Int? = null,
    val message: String? = null,
    val success: Boolean? = null
)