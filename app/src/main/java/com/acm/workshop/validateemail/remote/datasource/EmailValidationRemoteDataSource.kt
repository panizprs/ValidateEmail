package com.acm.workshop.validateemail.remote.datasource

import com.acm.workshop.validateemail.remote.api.EmailValidationService
import com.acm.workshop.validateemail.remote.dto.IsValidEmail
import io.reactivex.Single

class EmailValidationRemoteDataSource(private val emailValidationService: EmailValidationService){

    fun isValidEmail(email: String) : Single<IsValidEmail> {
        return emailValidationService.isValidEmail(email)
    }
}