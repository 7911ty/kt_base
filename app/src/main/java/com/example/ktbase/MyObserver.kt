package com.example.ktbase

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver :LifecycleObserver {
    private val TAG = "MyObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onActivityStart(){
        Log.d(TAG, "onActivityStart: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onActivityStop(){
        Log.d(TAG, "onActivityStop: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAll(){
        Log.d(TAG, "onAll: ")
    }
}