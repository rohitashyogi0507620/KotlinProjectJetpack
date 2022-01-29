package com.yogify.kotlinprojectjetpack.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModule : ViewModel() {
    var namelivedata = MutableLiveData<String>("Rohitash")
    fun updatelivedata(data: String) {
        namelivedata.value = data;
    }
}