package com.yogify.kotlinprojectjetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDatabindingViewModule : ViewModel() {

    var namelivedata = MutableLiveData<NamedobData>(NamedobData("Komal", "26-07-1999"))

    fun updatelivedata() {
        var data = NamedobData("Seema", "1-5-1999")
        namelivedata.value = data;
    }
}