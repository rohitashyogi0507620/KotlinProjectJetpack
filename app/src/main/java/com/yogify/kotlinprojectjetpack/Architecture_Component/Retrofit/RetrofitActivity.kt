package com.yogify.kotlinprojectjetpack.Architecture_Component.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM.Adapter
import com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM.ProgramingItem
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityRetrofitBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitBinding
    lateinit var quoteslist: MutableList<Result>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)

        val quotesAPI = RetrofitHealper.getInstace().create(QuotesAPI::class.java)
        val adapter = AdapterQuotes()
        binding.recylearview.layoutManager = LinearLayoutManager(this)
        binding.recylearview.setHasFixedSize(true)

        val singledata = Result(
            "QdK00IhCNX",
            "Rohitash Yogi",
            "larry-page",
            "If you're changing the world, you're working on important things. You're excited to get up in the morning.",
            "2021-06-18",
            "2021-06-18",
            106,
            listOf("famous-quotes", "inspirational")
        )

        GlobalScope.launch {
            val result = quotesAPI.getQuotes(1)
            if (result != null) {
                quoteslist = result.body()!!.results
                Log.d("DataSize", quoteslist.size.toString())
                runOnUiThread(Runnable {
                    quoteslist.add(singledata)
                    adapter.submitList(quoteslist)
                    binding.recylearview.adapter = adapter
                    binding.progerssbar.visibility = View.GONE

                })
            }
        }

        binding.btnchnagedata.setOnClickListener {
            binding.progerssbar.visibility = View.VISIBLE

            GlobalScope.launch {
                val result = quotesAPI.getQuotes(2)
                if (result != null) {
                    quoteslist = result.body()!!.results
                    Log.d("DataSize", quoteslist.size.toString())
                    runOnUiThread(Runnable {
                        quoteslist.add(singledata)
                        adapter.submitList(quoteslist)
                        binding.progerssbar.visibility = View.GONE

                    })
                }
            }
        }

// Fix Data Android
//        val singledata = Result(
//            "QdK00IhCNX",
//            "Rohitash Yogi",
//            "larry-page",
//            "If you're changing the world, you're working on important things. You're excited to get up in the morning.",
//            "2021-06-18",
//            "2021-06-18",
//            106,
//            listOf("famous-quotes", "inspirational")
//        )
//        val singledata2 = Result(
//            "QdK00IhCNX",
//            "Larry Page",
//            "larry-page",
//            "If you're changing the world, you're working on important things. You're excited to get up in the morning.",
//            "2021-06-18",
//            "2021-06-18",
//            106,
//            listOf("famous-quotes", "inspirational")
//        )
//        val singledata3 = Result(
//            "QdK00IhCNX",
//            "Seema Yogi",
//            "larry-page",
//            "If you're changing the world, you're working on important things. You're excited to get up in the morning.",
//            "2021-06-18",
//            "2021-06-18",
//            106,
//            listOf("famous-quotes", "inspirational")
//        )
//        val singledata4 = Result(
//            "QdK00IhCNX",
//            "Aditya Page",
//            "larry-page",
//            "If you're changing the world, you're working on important things. You're excited to get up in the morning.",
//            "2021-06-18",
//            "2021-06-18",
//            106,
//            listOf("famous-quotes", "inspirational")
//        )
//        adapter.submitList(listOf(singledata, singledata2, singledata3, singledata4))
//        binding.recylearview.adapter = adapter


    }
}