package com.example.myportfolioadminapp.feature.personal_info.presentation


sealed class PersonalInfoUiEvent {
    data class NameChanged(val name: String) : PersonalInfoUiEvent()
    data class DesignationChanged(val designation: String) : PersonalInfoUiEvent()
    data class TitleChanged(val title: String) : PersonalInfoUiEvent()
    data class DescriptionChanged(val description: String) : PersonalInfoUiEvent()
    data class DobChanged(val dob: Long) : PersonalInfoUiEvent()
    data class LocationChanged(val location: String) : PersonalInfoUiEvent()
    data class MailChanged(val mail: String) : PersonalInfoUiEvent()
    data class PhNoChanged(val phNo: String) : PersonalInfoUiEvent()
    data class GithubUrlChanged(val githubUrl: String) : PersonalInfoUiEvent()
    data class LinkedinUrlChanged(val linkedinUrl: String) : PersonalInfoUiEvent()
    data class PlaystoreUrlChanged(val playStoreUrl: String) : PersonalInfoUiEvent()
    data object InsertInfo : PersonalInfoUiEvent()
}