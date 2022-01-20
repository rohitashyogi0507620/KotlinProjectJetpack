package com.yogify.kotlinprojectjetpack.Architecture_Component.LifeCycleObserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yogify.kotlinprojectjetpack.R

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        lifecycle.addObserver(Observer())
        Log.d("MAIN","Activity On Create")

    }
}