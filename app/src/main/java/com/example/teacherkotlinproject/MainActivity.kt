package com.example.teacherkotlinproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    1. Добавить 2-й EditText в activity_main
    2. Переделать функцию на получение данных с 2-х EditText и суммировать их
    3. Сделать клавиатуру где отображаются только цифры.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        text_view.text = getName(60)
//        Log.v("CREATED_NAME", getName(60))
        changeTextAction()
    }

    private fun changeTextAction() {
        change.setOnClickListener {
            var value = edit_text.text.toString()
            text_view.text = value
            edit_text.text.clear()
//            change.setTextColor(resources.getColor(R.color.changeButtonText))
        }
    }

//    var createdName: String = "Ромео"
//
//    fun getName(age: Int): String {
//        return createdName + age
//    }
//
//    fun getFirstName(age: Int):String{
//        return createdName + age
//    }
//
//    fun getLastName(age: Int):String{
//        return createdName + age
//    }

    /*
    1. Всё следить за пробелами и отступами
    2. Всегда логически называть переменные и методы
    //    var a, d, eqafaf, - плохо!
    // var name, lastName, age - очень хорошо!
     */

    //Что такое переменная? - Ячейка памяти для хранения информации.
    //int, Boolean, double, String, float, char

    //var - переменная, age - название,
    // : Int - наследоване или пренадлежность к опредленному типу,
    // = 40 - значение

    /*RES*/
    //drawable - Векторные //svg, pdf
    //mipmap - Растровые //jpeg, jpg, png, gif
    //layout - Скрины, списки
    //values - переводы строк, цвета, размеры, стили

    /*Gradle Scripts*/

    //github, gitlab - vcs - version control code
}