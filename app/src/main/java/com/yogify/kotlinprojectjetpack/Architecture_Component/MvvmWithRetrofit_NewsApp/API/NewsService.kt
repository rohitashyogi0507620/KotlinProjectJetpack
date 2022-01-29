package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API

import android.provider.MediaStore
import androidx.annotation.StyleRes
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.Article
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsService {


    @GET(Api_Constant.EVERTHING)
    suspend fun getAllArticals(
        @Query(Api_Constant.DOMIANS) domain: String,
        @Query(Api_Constant.API_KRY) apikey: String
    ): Response<NewsData>

}