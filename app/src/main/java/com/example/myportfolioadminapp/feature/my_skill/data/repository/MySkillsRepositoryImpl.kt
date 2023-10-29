package com.example.myportfolioadminapp.feature.my_skill.data.repository

import com.example.myportfolioadminapp.feature.my_skill.data.dto.allSkillsCategory.AllSkillsCategoryDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.delete_skill.DeleteSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.get_categories.AllCategoriesDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.get_skill.GetSkillDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.insert_skill.InsertSkillDataDTO
import com.example.myportfolioadminapp.feature.my_skill.data.dto.update_skill.UpdateSkillDTO
import com.example.myportfolioadminapp.feature.my_skill.data.remote.MySkillsApi
import com.example.myportfolioadminapp.feature.my_skill.domain.model.request.SkillRequest
import com.example.myportfolioadminapp.feature.my_skill.domain.repository.MySkillsRepository
import javax.inject.Inject


class MySkillsRepositoryImpl @Inject constructor(
    private val api: MySkillsApi
): MySkillsRepository {


    override suspend fun getAllMySkillsCategories(): List<AllSkillsCategoryDataDTO> {
        return api.getAllMySkillsCategories().data
    }

    override suspend fun getAllCategories(): List<AllCategoriesDataDTO>? {
        return api.getAllCategories()?.data
    }

    override suspend fun insertSkill(categoryId: String, request: SkillRequest): InsertSkillDataDTO? {
        return api.insertSkill(categoryId, request)?.data
    }

    override suspend fun getSkill(skillId: String): GetSkillDataDTO? {
        return api.getSkill(skillId)?.data
    }

    override suspend fun updateSkill(skillId: String, request: SkillRequest): UpdateSkillDTO? {
        return api.updateSkill(skillId, request)
    }

    override suspend fun deleteSkill(skillId: String): DeleteSkillDTO? {
        return api.deleteSkill(skillId)
    }
}