package com.example.userapplication.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.userapplication.network.rest.dto.Category
import kotlinx.coroutines.*

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    var job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.IO)
    var persons: MutableLiveData<List<Category>> = MutableLiveData()
    var size: MutableLiveData<String> = MutableLiveData()


    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}