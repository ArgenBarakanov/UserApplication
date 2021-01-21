package com.example.userapplication.viewmodel

import android.app.Application
import android.content.Context

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.userapplication.network.rest.client.PersonApi
import com.example.userapplication.network.rest.client.PersonApiService
import com.example.userapplication.network.rest.dto.Person
import kotlinx.coroutines.*
import java.lang.Exception

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    var job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.IO)
    var persons: MutableLiveData<List<Person>> = MutableLiveData()
    var size: MutableLiveData<String> = MutableLiveData()


    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}