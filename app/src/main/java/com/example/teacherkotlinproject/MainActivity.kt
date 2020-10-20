package com.example.teacherkotlinproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
    1. Сделать проверку на ввод пустого сообщения,
    если вы добавляете пустое сообщение, то вывести Toast
    "Нельзя добавить пустое значение." и не добавлять в массив. - done

    2.Сделать проверку на добавление нового элемента,
    элемент не должен быть короче 3-х символов, если вы вводите значение меньше 3-х символов,
    то выводить Toast с сообщнием: "Значение должно быть больше 2-х символов." - done

    3. Если вы хотите удалить значение из массива и его нет,
    то отображать Toast "Элемент для удаления не найден" и очищать EditText. - done
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
            val value = enter_text_edit_text.text.toString().trim()
            if (value.isEmpty()) {
                showToast("Нельзя добавить пустое значение.")
                return@setOnClickListener
            }

            if (value.length < 3) {
                showToast("Значение должно быть больше 2-х символов.")
                return@setOnClickListener
            }
            enter_text_edit_text.text.clear()
            textArray.add(value)
            displayTextArray()
        }
    }

    private fun removeFromArray() {
        remove_button.setOnClickListener {
            var value = enter_text_delete_edit_text.text.toString().trim()
            if (value.isEmpty()) {
                showToast("Для удаления нужно ввести значение.")
                return@setOnClickListener
            }
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
        if (element.isEmpty()) {
            showToast("Элемент для удаления не найден.")
            return
        }
        if (indexOfArray != null) {
            textArray.removeAt(indexOfArray)
            showToast("Мы удалили $element")
        }
    }

    private fun displayTextArray() {
        var result = ""
        for (text in textArray) {
            result = "$result $text \n"
        }
        all_elements_text_view.text = result
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}