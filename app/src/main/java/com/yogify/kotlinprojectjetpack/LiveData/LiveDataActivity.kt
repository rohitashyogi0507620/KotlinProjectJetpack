package com.yogify.kotlinprojectjetpack.LiveData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.LiveDatabindingViewModule
import com.yogify.kotlinprojectjetpack.NamedobData
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    lateinit var mainViewModule: LiveDataViewModule // simple Data View module andorid
    lateinit var bindinviewmodule: LiveDatabindingViewModule

    lateinit var binding: ActivityLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)

        mainViewModule = ViewModelProvider(this).get(LiveDataViewModule::class.java)
        mainViewModule.namelivedata.observe(this, Observer {
            binding.txtdata.text = it
        })

        binding.btnupdatadata.setOnClickListener {
            mainViewModule.updatelivedata("Aditya")
        }

        // Data binding Concept is used to bind data into view on xml it self

        var singledata = NamedobData("Rohitash yogi", "04-07-1998")
        binding.datauser = singledata

        // One Way Data Binding Where Data Flow One side , Only to the views
        // Data Binding with Live data
        // Create then Set Lifecycler Owner
        // Then View Module

        bindinviewmodule = ViewModelProvider(this).get(LiveDatabindingViewModule::class.java)
        binding.lifecycleOwner = this
        binding.liveviewmodule = bindinviewmodule


    }
}