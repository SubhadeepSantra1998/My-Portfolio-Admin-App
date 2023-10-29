package com.example.myportfolioadminapp.feature.my_skill.domain.repository

import com.example.myportfolioadminapp.feature.my_skill.data.dto.allSkillsCategory.AllSkillsCategoryDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.delete_skill.DeleteSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.get_categories.AllCategoriesDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.get_skill.GetSkillDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.insert_skill.InsertSkillDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.update_skill.UpdateSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.domain.model.request.SkillRequest

interface  MySkillsRepository {

    suspend fun getAllMySkillsCategories(): List<AllSkillsCategoryDataDTO>

    suspend fun getAllCategories(): List<AllCategoriesDataDTO>?

    suspend fun insertSkill(categoryId: String, request: SkillRequest): InsertSkillDataDTO?

    suspend fun getSkill(skillId: String): GetSkillDataDTO?

    suspend fun updateSkill(skillId: String, request: SkillRequest): UpdateSkillDTO?

    suspend fun deleteSkill(skillId: String): DeleteSkillDTO?
}