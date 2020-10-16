package com.example.teacherkotlinproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Сергей
    // Адеми
    //Айпери
    //Азиза

    //unmutable array
//    var member = arrayOf("Сергей", "Адеми", "Айпери", "Азиза") //0, 1, 2, 3
//    var memberMutable = mutableListOf("Сергей", "Адеми", "Айпери", "Азиза") //0, 1, 2, 3
//    var ageArray = arrayOf<Int>()
//    var ageMutable = mutableListOf<Int>()

    public var total = 100
    var animals = mutableListOf("cat", "dog", "bat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        displayAnimals()
    }

    fun displayAnimals() {
//        for (animal in animals) {
//           Log.v("ANIMALS", animal)
//        }
//        Log.v("ANIMAL_AT", animals[2])
//
//        for (n in 1..9) {
//            Log.v("RANGE", "step $n")
//        }
        var total = 100
        while (total != 0) {
            Log.v("TOTAL", "total is =$total")
            total -= 1
        }

    }

}