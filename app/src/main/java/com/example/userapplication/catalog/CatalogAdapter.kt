package com.example.userapplication.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.userapplication.R
import com.example.userapplication.databinding.CatalogItemBinding
import com.example.userapplication.network.rest.dto.Category

class CatalogAdapter(val viewModel: CatalogViewModel): RecyclerView.Adapter<CatalogItemViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    var data = listOf<Category>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
         val catalogITem = data[position]
         val productAdapter = ProductAdapter(viewModel)
        productAdapter.products = catalogITem.products
        holder.catalogItemBinding?.catalog = catalogITem
        holder.catalogItemBinding?.products?.apply {
            adapter = productAdapter
            setRecycledViewPool(viewPool)
        }

        holder.catalogItemBinding?.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CatalogItemBinding>(layoutInflater, R.layout.catalog_item,parent, false)
        return CatalogItemViewHolder(binding)
    }
}