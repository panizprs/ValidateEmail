package com.acm.workshop.validateemail.data.repository

import com.acm.workshop.validateemail.app.executor.BackgroundThread
import com.acm.workshop.validateemail.app.executor.MainThread
import com.acm.workshop.validateemail.remote.api.main
import com.acm.workshop.validateemail.remote.datasource.EmailValidationRemoteDataSource
import com.acm.workshop.validateemail.remote.dto.IsValidEmail
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class EmailValidationRepository @Inject constructor(
    private val emailValidationRemoteDataSource: EmailValidationRemoteDataSource,
    private val mainThread: MainThread,
    private val backgroundThread: BackgroundThread){

    private val disposables = CompositeDisposable()

    fun isValidEmail(email: String, onSuccess : (IsValidEmail) -> Unit, onFailure : (Throwable) -> Unit){
        emailValidationRemoteDataSource.isValidEmail(email)
            .subscribeOn(backgroundThread.scheduler)
            .observeOn(mainThread.scheduler)
            .subscribe({ isValidEmail ->
                println("repo isValidEmail: ${isValidEmail.isValid}")
                onSuccess(isValidEmail)
            },{error ->
                println("repo isValidEmail: ${error.message}")
                onFailure(error)
            }).addTo(disposables)
    }
}