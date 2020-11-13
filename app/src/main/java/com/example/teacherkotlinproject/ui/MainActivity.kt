package com.example.teacherkotlinproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Добавить ещё 3 города (Картинка, Название, описание)
    //Добавить: отступ слева, стиль для Названия города, стиль для Описание города.
    //Прочитать про RecyclerView
    //Прочитать про data classes

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = MainAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        adapter.updateItems(cityArray)
    }

}