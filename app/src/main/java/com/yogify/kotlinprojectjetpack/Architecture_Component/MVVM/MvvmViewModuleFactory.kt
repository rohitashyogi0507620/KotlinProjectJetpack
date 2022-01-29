package com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.ViewModule.ViewModuleFactory

class MvvmViewModuleFactory(val repository: ContactRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmviewModule(repository = repository) as T
    }
}