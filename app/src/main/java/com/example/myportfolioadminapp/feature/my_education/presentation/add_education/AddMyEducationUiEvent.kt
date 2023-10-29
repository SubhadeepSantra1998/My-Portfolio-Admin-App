package com.example.myportfolioadminapp.feature.my_education.presentation.add_education

sealed class AddMyEducationUiEvent{

    data class InstitutionChanged(val institution: String) : AddMyEducationUiEvent()
    data class BoardChanged(val board: String) : AddMyEducationUiEvent()
    data class LocationChanged(val location: String) : AddMyEducationUiEvent()
    data class CourseChanged(val course: String) : AddMyEducationUiEvent()
    data class GradeChanged(val grade: String) : AddMyEducationUiEvent()
    data class StatusChanged(val status: Boolean) : AddMyEducationUiEvent()
    data class OnCategoryMenuChanged(val categoryId: String): AddMyEducationUiEvent()
    data object SaveEducation : AddMyEducationUiEvent()

}