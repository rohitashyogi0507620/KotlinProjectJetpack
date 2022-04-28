package com.yogify.kotlinprojectjetpack.NewChanges

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.yogify.kotlinprojectjetpack.R

class SecondActivity : AppCompatActivity() {
    lateinit var txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        txt = findViewById(R.id.txtview)
        txt.text = intent.getStringExtra("Name")

    }

    fun fun_SendToactivity(view: View) {
        Log.d("ActivityForResult","Go Back to main activity")
        setResult(1002, Intent().apply {
            putExtra("Name", "Hello Rohitash")
        })
       finish()
    }

}