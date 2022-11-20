package com.example.ktbase

import androidx.lifecycle.*

class MainViewModel3(count: Int) : ViewModel() {
    val counter: LiveData<Int>
        get() = _counter
    private val _counter = MutableLiveData<Int>()
    private val userIdLiveData = MutableLiveData<String>()

    val user:LiveData<User> = Transformations.switchMap(userIdLiveData){
        userId ->
        Repository.getUser(userId)
    }
    fun  getUser(userid:String){
        userIdLiveData.value = userid
    }

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
            return MainViewModel3(count) as T
        }
    }
}