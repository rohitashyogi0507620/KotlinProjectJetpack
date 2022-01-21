package com.yogify.kotlinprojectjetpack.Architecture_Component.LiveData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.yogify.kotlinprojectjetpack.Architecture_Component.QuotesApp.ViewModule.MainViewModule
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    lateinit var mainViewModule: LiveDataViewModule
    lateinit var binding: ActivityLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModule = ViewModelProvider(this).get(LiveDataViewModule::class.java)
        mainViewModule.namelivedata.observe(this, Observer {
            binding.txtdata.text = it
        })

        binding.btnupdatadata.setOnClickListener {
            mainViewModule.updatelivedata("Aditya")
        }
    }
}