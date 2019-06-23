package com.acm.workshop.validateemail.app.di.module

import com.acm.workshop.validateemail.app.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule{


    @ContributesAndroidInjector
    abstract fun homeFragment() : HomeFragment
}