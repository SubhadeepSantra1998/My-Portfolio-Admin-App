package com.example.myportfolioadminapp.feature.education_category.presentation.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class SharedViewModel : ViewModel() {

//    private val _isUpdateCategorySuccessful = MutableStateFlow(false)
//    val isUpdateCategorySuccessful: StateFlow<Boolean> get() = _isUpdateCategorySuccessful
//
//    fun setUpdateStatus(status: Boolean) {
//        _isUpdateCategorySuccessful.value = status
//    }
//
//    fun getUpdateStatus(): Boolean {
//        return isUpdateCategorySuccessful.value
//    }
//
//    fun resetUpdateStatus() {
//        _isUpdateCategorySuccessful.value = false
//    }


//    private val _updateStatus:MutableState<String> = mutableStateOf<String>("")
//    val updateStatus: State<String>  = _updateStatus

    private val _updateStatus = mutableStateOf("")
    val updateStatus: State<String> get() = _updateStatus

//    fun getUpdateStatus(): Boolean {
//        return _updateStatus.value
//    }

    fun setUpdateStatus(newStatus: String) {
        _updateStatus.value = newStatus
    }

}