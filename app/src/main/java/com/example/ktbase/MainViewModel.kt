package com.example.ktbase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(count: Int) : ViewModel() {
    var counter = count

     class MainViewModelFactory(private val count: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(count) as T
        }

    }
}