package com.yogify.kotlinprojectjetpack

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.Contact
import com.yogify.kotlinprojectjetpack.Architecture_Component.RoomDataBase.ContactDataBase
import com.yogify.kotlinprojectjetpack.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var database: ContactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)

        // Part :-- >>  1
        database = ContactDataBase.getDataBase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(
                Contact(
                    0, "Sankalp Agarwal", "7611920581", "Iageodff",
                    Date(), 0
                )
            )
        }

        binding.floatingbutton.setOnClickListener {
            database.contactDao().getContact().observe(this, Observer {
                Log.d("RoomDataBase", it.toString())
            })
        }

        // Part :-- >>> 2

        // Type Coverter if we need to store other data type in SQLite then need to used type converter
        // Supported Data Type is :--->> NULL,INTEGER,REAL,TEXT,BLOB

        // Part :-->> 3 Migration from one verion to next  ersion


    }
}