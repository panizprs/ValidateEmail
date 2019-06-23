package com.acm.workshop.validateemail.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.validateemail.data.repository.EmailValidationRepository
import com.acm.workshop.validateemail.remote.dto.IsValidEmail

class HomeViewModel(private val repository: EmailValidationRepository) : ViewModel(){


    private val _emailValidation = MutableLiveData<Boolean>()
    val emailValidation : LiveData<Boolean> = _emailValidation

    private val _errorEmailValidation = MutableLiveData<Throwable>()
    val errorEmailValidation : LiveData<Throwable> = _errorEmailValidation


    fun isEmailValid(email : String){
        repository.isValidEmail(email, ::successValidateEmail, ::failValidateEmail)
    }

    private fun successValidateEmail(isValidEmail: IsValidEmail){
        _emailValidation.value = isValidEmail.isValid
        println("result ${isValidEmail.isValid}")
    }

    private fun failValidateEmail(throwable: Throwable){
        _errorEmailValidation.value = throwable
        println("error ${throwable.message}")
    }

}