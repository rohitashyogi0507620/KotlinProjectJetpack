package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ViewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Repository.NewsRepository

class NewsViewModuleFactory(private val reposotory: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModule(reposotory) as T
    }
}