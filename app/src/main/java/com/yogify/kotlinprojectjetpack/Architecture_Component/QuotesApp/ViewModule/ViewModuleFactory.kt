package com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.ViewModule

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModuleFactory(var context: Context):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModule(context) as T
    }
}