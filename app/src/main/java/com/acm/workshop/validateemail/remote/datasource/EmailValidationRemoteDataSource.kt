package com.acm.workshop.validateemail.remote.datasource

import com.acm.workshop.validateemail.remote.api.EmailValidationService
import com.acm.workshop.validateemail.remote.dto.IsValidEmail
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EmailValidationRemoteDataSource @Inject constructor(
    private val emailValidationService: EmailValidationService
) {

    fun isValidEmail(email: String): Single<IsValidEmail> {
        return emailValidationService.isValidEmail(email)
    }
}