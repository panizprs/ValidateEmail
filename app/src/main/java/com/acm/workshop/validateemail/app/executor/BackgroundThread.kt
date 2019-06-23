package com.acm.workshop.validateemail.app.executor

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class BackgroundThread @Inject constructor(){
    val scheduler = Schedulers.io()
}