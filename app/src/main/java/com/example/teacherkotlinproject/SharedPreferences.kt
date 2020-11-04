package com.example.teacherkotlinproject

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val TEXT_PREF = "text_from_edit_text"
const val IS_HAS_PERSONAL_DATA_PREF = "is_has_personal_data"
class SharedPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("kotlin-app", Context.MODE_PRIVATE)

    var myPersonalData: String
    get() {
        return sharedPreferences.getStringOrDefault(TEXT_PREF)
    }
    set(value) {
        sharedPreferences.edit {
            putString(TEXT_PREF, value)
        }
    }

    var isHasPersonalData: Boolean
        get() {
            return sharedPreferences.getBoolean(IS_HAS_PERSONAL_DATA_PREF, false)
        }
        set(value) {
            sharedPreferences.edit {
                putBoolean(IS_HAS_PERSONAL_DATA_PREF, value)
            }
        }

    private fun SharedPreferences.getStringOrDefault(key: String, default: String = "") =
        getString(key, default) ?: default
}

