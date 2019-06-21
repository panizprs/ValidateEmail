package com.acm.workshop.validateemail.data.repository

import com.acm.workshop.validateemail.remote.datasource.EmailValidationRemoteDataSource
import com.acm.workshop.validateemail.remote.dto.IsValidEmail
import io.reactivex.Single

class EmailValidationRepository(private val emailValidationRemoteDataSource: EmailValidationRemoteDataSource){

    fun isValidEmail(email: String) : Single<IsValidEmail> {
        return emailValidationRemoteDataSource.isValidEmail(email)
    }
}