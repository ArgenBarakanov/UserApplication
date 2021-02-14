package com.example.userapplication.catalog

import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.databinding.CatalogItemBinding
import com.example.userapplication.databinding.ProductChildItemBinding


class CatalogItemViewHolder(val binding: CatalogItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    var catalogItemBinding: CatalogItemBinding?

    init {
        catalogItemBinding = binding
    }
}


class ProductChildItemViewHolder(val binding: ProductChildItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    var prodcutChildItemBinding: ProductChildItemBinding?

    init {
        prodcutChildItemBinding = binding
    }
}