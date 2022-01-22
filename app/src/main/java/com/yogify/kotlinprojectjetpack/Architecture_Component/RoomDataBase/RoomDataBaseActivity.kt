package com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.yogify.kotlinprojectjetpack.R

import com.yogify.kotlinprojectjetpack.databinding.ActivityRoomDataBaseBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RoomDataBaseActivity : AppCompatActivity() {
    lateinit var database: ContactDataBase
    lateinit var binding: ActivityRoomDataBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_room_data_base)


        // Part :-- >>  1
        database = ContactDataBase.getDataBase(this)



        binding.btngetdata.setOnClickListener {
            database.contactDao().getContact().observe(this, androidx.lifecycle.Observer {
                Log.d("RoomDataBase", it.toString())
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            })
        }
        binding.btninsertdata.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().insertContact(
                    Contact(
                        0, "Sankalp Agarwal", "7611920581", "Iageodff",
                        Date(), 0
                    )
                )
            }
        }

        // Part :-- >>> 2

        // Type Coverter if we need to store other data type in SQLite then need to used type converter
        // Supported Data Type is :--->> NULL,INTEGER,REAL,TEXT,BLOB

        // Part :-->> 3 Migration from one verion to next  ersion

    }
}