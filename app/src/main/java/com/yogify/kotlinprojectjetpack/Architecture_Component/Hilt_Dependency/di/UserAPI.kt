package com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di

import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.Models.Product
import com.yogify.kotlinprojectjetpack.Architecture_Component.Hilt_Dependency.di.UserConstant.PRODUCTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface UserAPI {


    @GET(PRODUCTS)
    suspend fun getproduct(): Response<List<Product>>

}