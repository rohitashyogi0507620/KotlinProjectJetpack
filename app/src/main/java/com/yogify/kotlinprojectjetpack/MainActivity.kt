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
import androidx.room.Room
import com.yogify.kotlinprojectjetpack.RoomDataBase.Contact
import com.yogify.kotlinprojectjetpack.RoomDataBase.ContactDataBase
import com.yogify.kotlinprojectjetpack.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        database = ContactDataBase.getDataBase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "Rohitash Yogi", "7611920581", "sdgs"))
        }

        binding.floatingbutton.setOnClickListener {
            database.contactDao().getContact().observe(this, Observer {
                Log.d("RoomDataBase", it.toString())
            })
        }
    }
}