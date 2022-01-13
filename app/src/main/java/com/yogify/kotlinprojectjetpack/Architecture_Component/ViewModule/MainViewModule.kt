package com.yogify.kotlinprojectjetpack.Architecture_Component.ViewModule

import androidx.lifecycle.ViewModel

class MainViewModule(var counter:Int) : ViewModel() {

    var count = counter

    fun increament() {
        count++
    }

}