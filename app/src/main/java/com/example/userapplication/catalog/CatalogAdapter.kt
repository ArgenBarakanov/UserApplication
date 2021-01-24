package com.example.userapplication.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.R
import com.example.userapplication.databinding.ProductItemBinding
import com.example.userapplication.network.rest.dto.Category

class CatalogAdapter: RecyclerView.Adapter<ProductItemViewHolder>() {

    var data = listOf<Category>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
         holder.productItemBinding?.product = data[position]
        holder.productItemBinding?.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ProductItemBinding>(layoutInflater, R.layout.product_item,parent, false)
        return ProductItemViewHolder(binding)
    }
}