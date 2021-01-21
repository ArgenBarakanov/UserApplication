package com.example.userapplication.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.R
import com.example.userapplication.TextItemViewHolder
import com.example.userapplication.network.rest.dto.Person

class CatalogAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<Person>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        holder.view.text = data[position].name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
       val layout = LayoutInflater.from(parent.context)
        val view = layout
            .inflate(R.layout.product_item, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}