package com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.DataClass.Quotes
import com.yogify.kotlinprojectjetpack.Architecture_Component.Android_Paging.Paging.AdapterQuotes
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ApplicationClass
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.Utils.NetworkUtils
import com.yogify.kotlinprojectjetpack.Architecture_Component.MvvmWithRetrofit_NewsApp.ViewModule.NewsViewModule
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityPagingBinding

class PagingActivity : AppCompatActivity() {

    lateinit var binding: ActivityPagingBinding
    lateinit var viewmodule: NewsViewModule
    private lateinit var quoteslist: List<Quotes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_paging)

        val repository = (application as ApplicationClass).newsRepository

        quoteslist = mutableListOf()
        val adapter = AdapterQuotes(this, quoteslist)
        binding.recylearview.layoutManager = LinearLayoutManager(this)
        binding.recylearview.setHasFixedSize(true)
        binding.recylearview.adapter = adapter

//        if (NetworkUtils.isOnline(applicationContext)) {
//            val result = newsservice.getAllArticals(domains, apikey)
//            if (result?.body() != null) {
//                articaldatabase.getDAO().addArticles(result.body()!!.articles)
//                articalslist.postValue(result.body())
//            }
//
//        }

//        viewmodule.articallist.observe(this, Observer {
//            if (it != null) {
//                quoteslist = it.articles
//                adapter.updateListItem(quoteslist)
//            }
//        })


    }
}