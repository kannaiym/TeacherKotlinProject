package com.example.teacherkotlinproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherkotlinproject.City
import com.example.teacherkotlinproject.R

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var array = mutableListOf<City>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.description.text = item.description
    }

    fun updateItems(items: MutableList<City>) {
        array = items
        notifyDataSetChanged()
    }

    fun addItem(value: City) {
        array.add(value)
        notifyItemInserted(array.lastIndex)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var description: TextView = itemView.findViewById(R.id.description)
        var image: ImageView = itemView.findViewById(R.id.image)
    }
}