package com.yogify.kotlinprojectjetpack.Architecture_Component.LifeCycleObserver

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun oncreatework(){

        Log.d("MAIN","On Create Observer")
    }
}