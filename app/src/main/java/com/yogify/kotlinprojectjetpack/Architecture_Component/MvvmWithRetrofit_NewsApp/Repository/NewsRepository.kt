package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.Api_Constant
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.NewsService
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.LocalDataBase.ArticleDatabase
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.NewsData
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Utils.NetworkUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsRepository(
    val newsservice: NewsService,
    val articaldatabase: ArticleDatabase,
    val applicationContext: Context
) {

    val articalslist = MutableLiveData<NewsData>()
    val articals: LiveData<NewsData>
        get() = articalslist

    suspend fun getAllArticals(domains: String, apikey: String) {

        // NetWork Call for check Internet Connection
        if (NetworkUtils.isOnline(applicationContext)) {
            val result = newsservice.getAllArticals(domains, apikey)
            if (result?.body() != null) {
                articaldatabase.getDAO().addArticles(result.body()!!.articles)
                articalslist.postValue(result.body())
            }

        } else {
            val newslist = articaldatabase.getDAO().getArticles()
            val newsdata = NewsData(newslist, "200", 20)
            articalslist.postValue(newsdata)
        }

    }

    suspend fun getAllArticlesBackground() {

        val newdomain = "techcrunch.com"

        val result = newsservice.getAllArticals(newdomain, Api_Constant.KEY)
        if (result?.body() != null) {
            articaldatabase.getDAO().addArticles(result.body()!!.articles)
            articalslist.postValue(result.body())
        }

    }
}
