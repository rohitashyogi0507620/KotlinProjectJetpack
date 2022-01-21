package com.yogify.kotlinprojectjetpack.Architecture_Component.LiveData

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)

        mainViewModule = ViewModelProvider(this).get(LiveDataViewModule::class.java)
        mainViewModule.namelivedata.observe(this, Observer {
            binding.txtdata.text = it
        })

        binding.btnupdatadata.setOnClickListener {
            mainViewModule.updatelivedata("Aditya")
        }

        // Data binding concept is used to bind data into view on xml it self

        var singledata = NamedobData("Rohitash yogi", "04-07-1998")
        binding.name = "Rohitash yogi"
        binding.dob = "04-07-1998"

    }
}