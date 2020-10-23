package com.example.teacherkotlinproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.constrate_layout.*

class MainActivity : AppCompatActivity() {

    var count = 0
    var age = 0
    var weight = 0
    var size = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constrate_layout)
        Log.v("ACTIVITY_STATE", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.v("ACTIVITY_STATE", "onStart")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        age = savedInstanceState.getInt("age")
        weight = savedInstanceState.getInt("weight")
        size = savedInstanceState.getInt("size")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ACTIVITY_STATE", "onResume")
        count++
        Log.v("ACTIVITY_STATE_COUNT", "$count")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ACTIVITY_STATE", "onPause")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v("ACTIVITY_STATE", "onSaveInstanceState")
        outState.putInt("count", count)
        outState.putInt("age", age)
        outState.putInt("weight", weight)
        outState.putInt("size", size)
    }

    override fun onStop() {
        super.onStop()
        Log.v("ACTIVITY_STATE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ACTIVITY_STATE", "onDestroy")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}