package com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM.Adapter
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ApplicationClass
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Models.Article
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ViewModule.NewsViewModule
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ViewModule.NewsViewModuleFactory
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityMvvmRetrofitBinding
import com.yogify.kotlinprojectjetpack.databinding.ActivityPagingBinding

class PagingActivity : AppCompatActivity() {

    lateinit var binding: ActivityPagingBinding
    lateinit var viewmodule: NewsViewModule
    private lateinit var articlelist: List<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_paging)

        val repository = (application as ApplicationClass).newsRepository

        viewmodule = ViewModelProvider(
            this, NewsViewModuleFactory(repository)
        ).get(NewsViewModule::class.java)

        articlelist = mutableListOf()
        val adapter = AdapterNews(this, articlelist)
        binding.recylearview.layoutManager = LinearLayoutManager(this)
        binding.recylearview.setHasFixedSize(true)
        binding.recylearview.adapter = adapter


        viewmodule.articallist.observe(this, Observer {
            if (it != null) {
                articlelist = it.articles
                adapter.updateListItem(articlelist)
            }
        })


    }
}