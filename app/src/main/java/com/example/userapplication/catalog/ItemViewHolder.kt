package com.example.userapplication.catalog

import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.databinding.ProductItemBinding

class ProductItemViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
    var productItemBinding: ProductItemBinding?
    init {
        productItemBinding = binding
    }
}