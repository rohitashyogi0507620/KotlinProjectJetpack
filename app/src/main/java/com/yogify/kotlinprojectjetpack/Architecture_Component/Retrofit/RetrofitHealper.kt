package com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHealper {

    val BASEURL: String = "https://quotable.io/"

    fun getInstace(): Retrofit {
        return Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}