package com.yogify.kotlinprojectjetpack.Architecture_Component

import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.Article
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.NewsData

// Both Are Same
//sealed class Response() {
//    class Loading : Response()
//    class Sucess(val newslist: NewsData) : Response()
//    class Error(val errormessage: String) : Response()
//}

// We Used This for API Calling
// But for Many API Caling we are using Genrerics data type as n reponse

//sealed class Response(val data: NewsData? = null, val errormesage: String? = null) {
//
//    class Loading : Response()
//    class Sucess(newsdata: NewsData) : Response(data = newsdata)
//    class Error(errormessage: String) : Response(errormesage = errormessage)
//
//}

// Set Generics As DAta
sealed class Response<T>(val data: T? = null, val errormesage: String? = null) {

    class Loading<T> : Response<T>()
    class Sucess<T>(data: T? = null) : Response<T>(data = data)
    class Error<T>(errormessage: String) : Response<T>(errormesage = errormessage)

}
