package com.example.ktbase

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var viewModel: MainViewModel2
    lateinit var viewModel3: MainViewModel3
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.addObserver(MyObserver())
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getPreferences(Context.MODE_PRIVATE)
        val int = sp.getInt("count_reserved", 0)
        viewModel =
            ViewModelProvider(
                this,
                MainViewModel2.MainViewModelFactory(int)
            ).get(MainViewModel2::class.java)
        viewModel3 =
            ViewModelProvider(
                this,
                MainViewModel3.MainViewModelFactory(int)
            ).get(MainViewModel3::class.java)
        val button = findViewById<Button>(R.id.button)
        val clear = findViewById<Button>(R.id.clear)
        val getUserId = findViewById<Button>(R.id.getUserId)
        val findViewById = findViewById<TextView>(R.id.text)
        button.setOnClickListener {
            viewModel.plusOne()
        }
        clear.setOnClickListener {
            viewModel.clear()
        }
        getUserId.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel3.getUser(userId)
        }
        viewModel3.user.observe(this, Observer {
            user ->
            findViewById.text = user.firstName
        })
        viewModel.counter.observe(
            this, Observer { count ->
                findViewById.text = count.toString()
            }
        )
    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }

    private fun refreshText() {
        val findViewById = findViewById<TextView>(R.id.text)
        findViewById.text = viewModel.counter.toString()
    }
}