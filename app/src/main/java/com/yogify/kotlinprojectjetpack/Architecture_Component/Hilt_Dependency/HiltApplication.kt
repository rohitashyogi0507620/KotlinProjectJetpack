package com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency

import android.app.Application
import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.repository.UserReposotory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HiltApplication:Application() {

    @Inject
    lateinit var userReposotory: UserReposotory

    override fun onCreate() {
        super.onCreate()
        userReposotory
    }
}