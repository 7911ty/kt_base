package com.example.ktbase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel2(count: Int) : ViewModel() {
    val counter: LiveData<Int>
        get() = _counter
    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = count
    }

    fun plusOne() {
        val c = _counter.value ?: 0
        _counter.value = c + 1
    }

    fun clear() {
        _counter.value = 0
    }

    class MainViewModelFactory(private val count: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel2(count) as T
        }
    }
}