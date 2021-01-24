package com.example.userapplication.catalog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.userapplication.network.rest.client.PersonApi
import com.example.userapplication.network.rest.dto.Category
import kotlinx.coroutines.*

class CatalogViewModel(application: Application) : AndroidViewModel(application) {

    var viewModelJob = Job()
    val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)

    var persons: MutableLiveData<List<Category>> = MutableLiveData()

    fun fetchData() {
        if (persons.value.isNullOrEmpty()) {
            coroutineScope.launch {
                val data = PersonApi.retrofitService.getProperties()
                persons.postValue(data)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}