package com.example.myportfolioadminapp.feature.personal_info.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


//@HiltViewModel
//class PersonalInfoViewModel @Inject constructor(
//    private val personalInfoUseCases: PersonalInfoUseCase,
//) : ViewModel()
//{
//
//
//    var uiState by mutableStateOf(PersonalInfoUiState())
//        private set
//
//    fun onEvent(event: PersonalInfoUiEvent) {
//        when (event) {
//
//            is PersonalInfoUiEvent.NameChanged -> {
//                uiState = uiState.copy(name = event.name)
//            }
//            is PersonalInfoUiEvent.DesignationChanged -> {
//                uiState = uiState.copy(designation = event.designation)
//            }
//            is PersonalInfoUiEvent.TitleChanged -> {
//                uiState = uiState.copy(title = event.title)
//            }
//            is PersonalInfoUiEvent.DescriptionChanged -> {
//                uiState = uiState.copy(description = event.description)
//            }
//            is PersonalInfoUiEvent.DobChanged -> {
//                uiState = uiState.copy(dob = event.dob)
//            }
//            is PersonalInfoUiEvent.LocationChanged -> {
//                uiState = uiState.copy(location = event.location)
//            }
//            is PersonalInfoUiEvent.MailChanged -> {
//                uiState = uiState.copy(mail = event.mail)
//            }
//            is PersonalInfoUiEvent.PhNoChanged -> {
//                uiState = uiState.copy(phNo = event.phNo)
//            }
//            is PersonalInfoUiEvent.GithubUrlChanged -> {
//                uiState = uiState.copy(githubUrl = event.githubUrl)
//            }
//            is PersonalInfoUiEvent.LinkedinUrlChanged -> {
//                uiState = uiState.copy(linkedinUrl = event.linkedinUrl)
//            }
//            is PersonalInfoUiEvent.PlaystoreUrlChanged -> {
//                uiState = uiState.copy(playStoreUrl = event.playStoreUrl)
//            }
//            is PersonalInfoUiEvent.InsertInfo -> {
//                insertPersonalInfo()
//            }
//        }
//    }
//
//    private fun insertPersonalInfo() {
//        val nameResult = personalInfoUseCases.validateName(uiState.name)
//        val designationResult = personalInfoUseCases.validateDesignation(uiState.designation)
//        val titleResult = personalInfoUseCases.validateTitle(uiState.title)
//        val descriptionResult = personalInfoUseCases.validateDescription(uiState.description)
//        val dobResult = personalInfoUseCases.validateDob(uiState.dob)
//        val locationResult = personalInfoUseCases.validateLocation(uiState.location)
//        val mailResult = personalInfoUseCases.validateMail(uiState.mail)
//        val phNoResult = personalInfoUseCases.validatePhNo(uiState.phNo)
//        val githubUrlResult = personalInfoUseCases.validateGithubUrl(uiState.githubUrl)
//        val linkedinUrlResult = personalInfoUseCases.validateLinkedinUrl(uiState.linkedinUrl)
//        val playStoreUrlResult = personalInfoUseCases.validatePlaystoreUrl(uiState.playStoreUrl)
//
//        val hasError = listOf(
//            nameResult, designationResult, titleResult, descriptionResult, dobResult,locationResult, mailResult, phNoResult, githubUrlResult, linkedinUrlResult, playStoreUrlResult
//        ).any { !it.isSuccess }
//
//        if (hasError) {
//            uiState = uiState.copy(
//                nameError = nameResult.errorMessage,
//                designationError = designationResult.errorMessage,
//                titleError = titleResult.errorMessage,
//                descriptionError = descriptionResult.errorMessage,
//                dobError = dobResult.errorMessage,
//                locationError = locationResult.errorMessage,
//                mailError = mailResult.errorMessage,
//                phNoError = phNoResult.errorMessage,
//                githubUrlError = githubUrlResult.errorMessage,
//                linkedinUrlError = linkedinUrlResult.errorMessage,
//                playStoreUrlError = playStoreUrlResult.errorMessage
//            )
//        } else {
//            uiState = uiState.copy(
//                nameError = null,
//                designationError = null,
//                titleError = null,
//                descriptionError = null,
//                dobError = null,
//                locationError = null,
//                mailError = null,
//                phNoError = null,
//                githubUrlError = null,
//                linkedinUrlError = null,
//                playStoreUrlError = null
//            )
//
//            viewModelScope.launch {
//                val personalInfoRequest = PersonalInfoRequest(
//                    name = uiState.name,
//                    designation = uiState.designation,
//                    title = uiState.title,
//                    description = uiState.description,
//                    dob = uiState.dob,
//                    location = uiState.location,
//                    mail = uiState.mail,
//                    phNo = uiState.phNo,
//                    githubUrl = uiState.githubUrl,
//                    linkedinUrl = uiState.linkedinUrl,
//                    playStoreUrl = uiState.playStoreUrl
//                )
//
//                personalInfoUseCases.insertPersonalInfo(personalInfoRequest)
//                    .onStart {
//                        uiState = uiState.copy(
//                            isLoading = true
//                        )
//                    }
//                    .onEach { result ->
//                        uiState = when (result) {
//                            is Resource.Success -> {
//                                uiState.copy(
//                                    isLoading = false
//                                )
//                            }
//
//                            is Resource.Error -> {
//                                uiState.copy(
//                                    isLoading = false,
//                                    error = result.message
//                                )
//                            }
//
//                            is Resource.Loading -> {
//                                uiState.copy(
//                                    isLoading = true
//                                )
//                            }
//                        }
//                    }.launchIn(viewModelScope)
//            }
//        }
//    }
//
//    fun resetError() {
//        uiState = uiState.copy(error = null)
//    }
//
//}



@HiltViewModel
class PersonalInfoViewModel @Inject constructor(
) : ViewModel()
{

    private val _text = MutableLiveData("")
    val text: LiveData<String> get() = _text

    fun startTypingAnimation(inputText: String) {
        viewModelScope.launch {
            _text.value = ""
            inputText.forEach {
                delay(500) // Delay between characters, adjust as needed
                _text.value += it.toString()
            }
        }
    }

}