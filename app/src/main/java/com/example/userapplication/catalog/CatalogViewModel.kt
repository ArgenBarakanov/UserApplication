package com.example.userapplication.catalog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.userapplication.network.rest.client.PersonApi
import com.example.userapplication.network.rest.dto.Category
import com.example.userapplication.network.rest.dto.Product
import kotlinx.coroutines.*

class CatalogViewModel(application: Application) : AndroidViewModel(application) {

    var viewModelJob = Job()
    val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)

    var categories: MutableLiveData<List<Category>> = MutableLiveData()

    var selectedProduct: MutableLiveData<Product> = MutableLiveData();

    init {
        fetchData()
    }

    private fun fetchData() {
        if (categories.value.isNullOrEmpty()) {
            coroutineScope.launch {
                val data = PersonApi.retrofitService.getProperties()
                categories.postValue(data)
            }
        }
    }

    fun displaySelectedProduct(product: Product) {
        selectedProduct.value = product;
    }

    fun unSelectDisplayedProduct() {
        selectedProduct.value = null
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}