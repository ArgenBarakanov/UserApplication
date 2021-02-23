package com.example.userapplication.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.R
import com.example.userapplication.databinding.ProductChildItemBinding
import com.example.userapplication.network.rest.dto.Product

class ProductAdapter(val viewModel: CatalogViewModel) : RecyclerView.Adapter<ProductChildItemViewHolder>() {

    var products = listOf<Product>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductChildItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ProductChildItemBinding>(layoutInflater,R.layout.product_child_item, parent, false)
        return ProductChildItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductChildItemViewHolder, position: Int) {
        val product = products[position]
        holder.prodcutChildItemBinding?.product = product
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener{
            viewModel.displaySelectedProduct(product)
        }
    }
}