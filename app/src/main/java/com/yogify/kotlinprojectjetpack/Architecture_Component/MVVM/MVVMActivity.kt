package com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.Contact
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.ContactDAO
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.ContactDataBase
import com.yogify.kotlinprojectjetpack.R
import com.yogify.kotlinprojectjetpack.databinding.ActivityMvvmactivityBinding
import com.yogify.kotlinprojectjetpack.databinding.ActivityRoomDataBaseBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MVVMActivity : AppCompatActivity() {
    lateinit var database: ContactDataBase
    lateinit var binding: ActivityMvvmactivityBinding
    lateinit var viewmodule: MvvmviewModule
    lateinit var repository: ContactRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmactivity)
        // Part :-- >>  1
        database = ContactDataBase.getDataBase(this)




        binding.btninsertData.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().insertContact(
                    Contact(
                        0,
                        binding.txtname.text.toString(),
                        binding.txtphone.text.toString(),
                        binding.txtimageurl.text.toString(),
                        Date(),
                        0
                    )
                )
            }
        }

        var dao = ContactDataBase.getDataBase(this).contactDao()
        repository = ContactRepository(dao)
        viewmodule = ViewModelProvider(
            this,
            MvvmViewModuleFactory(repository)
        ).get(MvvmviewModule::class.java)

        binding.btngetdata.setOnClickListener {

            viewmodule.getContact().observe(this, androidx.lifecycle.Observer {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            })
        }

    }
}