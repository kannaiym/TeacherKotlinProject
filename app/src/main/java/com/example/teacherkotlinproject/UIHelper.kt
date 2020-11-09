package com.example.teacherkotlinproject

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun checkFieldIsEmpty(value: String, context: Context, message: String): Boolean {
    if (value.isEmpty()) {
        showToast(context, message)
        return true
    }
    return false
}

fun checkFieldIsSame(first: String, second: String, context: Context, message: String): Boolean {
    if (first != second) {
        showToast(context, message)
        return true
    }

    if (first.length <= 6) {
        showToast(context, "Поле должно быть больше 6 символов")
        return true
    }
    return false
}

fun intentToNext(context: Context, clazz: Class<*>) {
    val intent = Intent(context, clazz)
    context.startActivity(intent)
}