package com.example.myportfolioadminapp.feature.my_education.presentation.my_education

import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.GetAllEducationsDataModel


data class MyEducationUiState(
    val isLoading: Boolean = false,
    val myEducation: List<GetAllEducationsDataModel>? = emptyList(),
    val deleteSuccessResponse: String?= null,
    val error : String? = "",

    val educationId: String = "",
    val board: String = "",
    val course: String? = null,
    val educationName : String = "",
    val showDialog: Boolean = false,
    var showUpdateDialog: Boolean = false,
    val showDeleteDialog: Boolean = false,
    val isDeleteLoading: Boolean = false,
    val isDeleteSuccess: Boolean = false,
    val isRefreshing: Boolean = false,
)
