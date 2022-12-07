package com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.repository

import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di.UserAPI
import javax.inject.Inject

class UserReposotory @Inject constructor(var userAPI: UserAPI) {

    fun  getproducts(){
        userAPI.getproduct()
    }
}