package com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.Api_Constant
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.NewsRetrofitHelper
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.API.NewsService
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.Article
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Repository.NewsRepository
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ViewModule.NewsViewModule
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ViewModule.NewsViewModuleFactory
import com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit.Result
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityMvvmRetrofitBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MvvmRetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmRetrofitBinding
    lateinit var viewmodule: NewsViewModule
    lateinit var articlelist: MutableList<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_retrofit)


        val repository = (application as ApplicationClass).newsRepository

        viewmodule = ViewModelProvider(this, NewsViewModuleFactory(repository)).get(NewsViewModule::class.java)

        viewmodule.articallist.observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, it.articles.size.toString(), Toast.LENGTH_SHORT).show()
            }
        })

    }


}