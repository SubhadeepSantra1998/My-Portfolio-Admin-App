package com.example.myportfolioadminapp.feature.personal_info.presentation


data class PersonalInfoUiState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val name: String = "",
    val nameError: Int? = null,
    val designation: String = "",
    val designationError: Int? = null,
    val title: String = "",
    val titleError: Int? = null,
    val description: String = "",
    val descriptionError: Int? = null,
    val dob: Long = 0,
    val dobError: Int? = null,
    val location: String = "",
    val locationError: Int? = null,
    val mail: String = "",
    val mailError: Int? = null,
    val phNo: String = "",
    val phNoError: Int? = null,
    val githubUrl: String = "",
    val githubUrlError: Int? = null,
    val linkedinUrl: String = "",
    val linkedinUrlError: Int? = null,
    val playStoreUrl: String = "",
    val playStoreUrlError: Int? = null,



)