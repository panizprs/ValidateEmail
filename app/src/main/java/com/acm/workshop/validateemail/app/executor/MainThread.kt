package com.acm.workshop.validateemail.app.executor

import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainThread @Inject constructor(){
    val scheduler = AndroidSchedulers.mainThread()
}