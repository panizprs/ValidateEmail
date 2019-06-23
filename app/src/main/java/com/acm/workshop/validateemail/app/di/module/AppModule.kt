package com.acm.workshop.validateemail.app.di.module

import com.acm.workshop.validateemail.app.ValidateEmailApp
import dagger.Module
import dagger.Provides


@Module
class AppModule{

    @Provides
    fun provideContext(app : ValidateEmailApp) = app.applicationContext

}