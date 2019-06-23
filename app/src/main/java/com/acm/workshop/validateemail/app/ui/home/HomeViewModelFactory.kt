package com.acm.workshop.validateemail.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.validateemail.data.repository.EmailValidationRepository
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val repository: EmailValidationRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }

}