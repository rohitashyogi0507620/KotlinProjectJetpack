package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API

import com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.DataClass.QuotesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesService {


    @GET(ApiConstant.QUOTES)
    suspend fun getQuotesList(
        @Query(ApiConstant.PAGE) pagenumber: Int,
    ): Response<QuotesData>

}