package com.yogify.kotlinprojectjetpack.Architecture_Component.MVVM

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
                binding.data = it.toString()
            })
        }

        // DiffUtils  if there is change in few row of data then all data is refetch and reload into
        //Recycler view that may wast of time for the same data with no change So we Used Diffutils to get only
        // Changed data in two list data
        //List Adpter is Used in this process
        binding.recylearview.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter()
        val p1 = ProgramingItem(1, "J", "Java")
        val p2 = ProgramingItem(2, "K", "Kotlin")
        val p3 = ProgramingItem(3, "C", "C++")
        val p4 = ProgramingItem(4, "O", "OPPs")
        val p5 = ProgramingItem(5, "P", "PHP")

        adapter.submitList(listOf(p1, p2, p3, p4, p5))
        binding.recylearview.setHasFixedSize(true)
        binding.recylearview.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val p1 = ProgramingItem(1, "J", "Jhuta")
            val p2 = ProgramingItem(2, "K", "Kutta")
            val p3 = ProgramingItem(3, "C", "C++")
            val p4 = ProgramingItem(4, "O", "Olenad")
            val p5 = ProgramingItem(5, "P", "Pagal")
            adapter.submitList(listOf(p1, p2, p3, p4, p5))

        }, 4000)

    }
}