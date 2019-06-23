package com.acm.workshop.validateemail.app.di

import com.acm.workshop.validateemail.app.ValidateEmailApp
import com.acm.workshop.validateemail.app.di.module.AppModule
import com.acm.workshop.validateemail.app.di.module.FragmentsModule
import com.acm.workshop.validateemail.app.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        FragmentsModule::class,
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<ValidateEmailApp>{

@Component.Factory
abstract class Factory : AndroidInjector.Factory<ValidateEmailApp>

}