package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp

import android.app.Application
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.NewsRetrofitHelper
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.NewsService
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.LocalDataBase.ArticleDatabase
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Repository.NewsRepository
import com.yogify.kotlinprojectjetpack.Architecture_Component.WorkManager.Worker.NewsWorker
import java.util.concurrent.TimeUnit
import kotlin.contracts.ContractBuilder

class ApplicationClass : Application() {
    lateinit var newsRepository: NewsRepository
    override fun onCreate() {
        super.onCreate()
        Initialization()
        SetWorker()
    }

    fun Initialization() {
        val newsapi = NewsRetrofitHelper.getInstance().create(NewsService::class.java)
        val database = ArticleDatabase.getDataBase(applicationContext)
        newsRepository = NewsRepository(newsapi, database, applicationContext)
    }

    fun SetWorker() {
        val constraint =
            androidx.work.Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
        val workerrequest = PeriodicWorkRequest.Builder(NewsWorker::class.java, 1, TimeUnit.MINUTES)
            .setConstraints(constraint)
            .build()
        WorkManager.getInstance(this).enqueue(workerrequest)
    }
}