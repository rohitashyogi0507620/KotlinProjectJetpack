package com.yogify.kotlinprojectjetpack.Architecture_Component.ViewModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.yogify.kotlinprojectjetpack.R

class ViewModuleWorkActivity : AppCompatActivity() {

    lateinit var viewmodule: MainViewModule
    lateinit var txtview: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_module_work)
        // When there is an configartion change then android recreate activity or fragment
        button = findViewById<Button>(R.id.btn_onlcick)
        txtview = findViewById<TextView>(R.id.txtview)
        viewmodule = ViewModelProvider(this).get(MainViewModule::class.java)

        settext()

        button.setOnClickListener {
            viewmodule.increament()
            settext()
        }

        // View Model Factory Create Object base on data

    }

    private fun settext() {
        txtview.text = viewmodule.count.toString()
    }
}