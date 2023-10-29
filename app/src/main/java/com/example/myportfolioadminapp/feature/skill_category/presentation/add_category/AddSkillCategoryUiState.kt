package com.example.myportfolioadminapp.feature.skill_category.presentation.add_category

data class AddSkillCategoryUiState(
    val isLoading: Boolean = false,
    val error : String? = "",
    val isSkillInsertionSuccess: Boolean = false,
    val title : String = "",
    val titleError : Int? = null,
    val titleErrorStatus: Boolean = true,
    val description : String = "",
    val descriptionError : Int? = null,
    val descriptionErrorStatus: Boolean = true,
    val status: Boolean = false,
    val isInputValidated: Boolean = false


)
