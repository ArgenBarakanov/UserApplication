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

    init {
        coroutineScope.launch {
            try{
                println("Get Request from api")
            val list = PersonApi.retrofitService.getProperties(getToken()!!)
                println("Size is: " + list.size)
                persons.postValue(list)
                size.postValue("" + list.size)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getToken():String? {
        return getApplication<Application>().getSharedPreferences("USER_API_PREFERENCES", Context.MODE_PRIVATE).getString("ACCESS_TOKEN",null)
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}