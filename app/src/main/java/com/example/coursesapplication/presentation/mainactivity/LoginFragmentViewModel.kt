package com.example.coursesapplication.presentation.mainactivity

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginFragmentViewModel : ViewModel() {

    val emailValid = MutableLiveData<Boolean>()

    fun isEmailValid(email : String){
        val isValid = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        emailValid.value = isValid
    }
}