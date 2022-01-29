package com.yogify.kotlinprojectjetpack.Architecture_Component.WorkManager.Worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ApplicationClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsWorker(val context: Context, val params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        Log.d("WorkerStarted", "WorkStart")
        val repository = (context as ApplicationClass).newsRepository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getAllArticlesBackground()
        }
        return Result.success()
    }
}