package com.example.userapplication.viewmodel

import android.app.Application
import android.content.Context

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.userapplication.network.rest.client.PersonApi
import com.example.userapplication.network.rest.dto.Person
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.lang.Exception

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    val listOfPersons by lazy {
            MutableLiveData(PersonApi.retrofitService.getProperties(getToken()!!).await())
    }
    fun getToken():String? {
        return getApplication<Application>().getSharedPreferences("USER_API_PREFERENCES", Context.MODE_PRIVATE).getString("ACCESS_TOKEN",null)
    }
}