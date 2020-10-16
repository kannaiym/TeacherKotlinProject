package com.example.teacherkotlinproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
    1. При добавлении элемента в массив сделать проверку на текст, текст не должен быть пустым.
    2. При удалении элемента из массива делать проверку на пустой ли элемент и выводить Toast.
     */
    var textArray = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addToArray()
        removeFromArray()
    }

    private fun addToArray() {
        add_button.setOnClickListener {
            val value = enter_text_edit_text.text.toString()
            enter_text_edit_text.text.clear()
            textArray.add(value)
            displayTextArray()
        }
    }

    private fun removeFromArray() {
        remove_button.setOnClickListener {
            var value = enter_text_delete_edit_text.text.toString()
            enter_text_delete_edit_text.text.clear()
            findAndRemoveFromArray(value)
            displayTextArray()
        }
    }

    private fun findAndRemoveFromArray(value: String) {
        var indexOfArray: Int? = null
        var element = ""
        for ((i, text) in textArray.withIndex()) {
            if (text == value) {
                indexOfArray = i
                element = text
            }
        }
        if (indexOfArray != null ) {
            textArray.removeAt(indexOfArray)
            Toast.makeText(this, "Мы удалили $element", Toast.LENGTH_LONG).show()
        }
    }

//    if (i != null ) {
//        textArray.removeAt(i)
//        Toast.makeText(this, toast, Toast.LENGTH_LONG).show()
//    }

//    if (i != null ) textArray.removeAt(i)

    private fun displayTextArray() {
        var result = ""
        for (text in textArray) {
            result = "$result $text \n"
        }
        all_elements_text_view.text = result
    }

}