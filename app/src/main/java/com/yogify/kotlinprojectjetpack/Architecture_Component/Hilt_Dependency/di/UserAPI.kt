package com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di

import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.Models.UserRequest
import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.Models.UserResponse
import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di.UserConstant.USER_SIGNIN
import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di.UserConstant.USER_SIGNUP
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface UserAPI {


    @GET(USER_SIGNIN)
    suspend fun signin(@Body userRequest: UserRequest): Response<UserResponse>

    @GET(USER_SIGNUP)
    suspend fun signup(@Body userRequest: UserRequest): Response<UserResponse>

}