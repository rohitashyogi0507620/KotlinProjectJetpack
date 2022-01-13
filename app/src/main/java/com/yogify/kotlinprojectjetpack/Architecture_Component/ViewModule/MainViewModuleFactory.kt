package com.yogify.kotlinprojectjetpack.Architecture_Component.ViewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModuleFactory(var counter:Int) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModule(counter) as T
    }
}