package com.example.userapplication.basket

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userapplication.network.rest.dto.Product

class BasketViewModel : ViewModel() {
    var text: MutableLiveData<String> = MutableLiveData()
    var buyBasket: MutableLiveData<MutableMap<Product?,Int?>> = MutableLiveData()

    init {
        text.value = "Argen"
        buyBasket.value = mutableMapOf()
    }

    fun changeNameOnButtonClick() {
        text.value = "Asel"
    }

    fun addProductToBasket(product: Product) {
        if( !buyBasket.value?.contains(product)!!) {
            buyBasket.value?.put(product,0)
        }
        buyBasket.value!!.put(product, buyBasket.value!!.get(product)?.plus(1))
    }
}