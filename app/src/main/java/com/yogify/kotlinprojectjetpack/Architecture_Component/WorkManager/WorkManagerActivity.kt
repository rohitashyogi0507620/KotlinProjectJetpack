package com.yogify.kotlinprojectjetpack.Architecture_Component.WorkManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit.QuotesAPI
import com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit.Result
import com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit.RetrofitHealper
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityWorkManagerBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WorkManagerActivity : AppCompatActivity() {
    lateinit var binding: ActivityWorkManagerBinding
    lateinit var quoteslist: MutableList<Result>
    lateinit var quotesAPI: QuotesAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_work_manager)

        quotesAPI = RetrofitHealper.getInstace().create(QuotesAPI::class.java)

        GlobalScope.launch {
            val result = quotesAPI.getQuotes(1)
            if (result != null) {
                quoteslist = result.body()!!.results
                Log.d("DataSize", quoteslist.size.toString())
                runOnUiThread(Runnable {

                })
            }
        }
    }


}