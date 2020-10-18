package com.example.userapplication.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.userapplication.network.rest.client.PersonApi
import com.example.userapplication.network.rest.dto.Person
import kotlinx.coroutines.launch
import java.lang.Exception

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    val listOfPersons by lazy {
        viewModelScope.launch {
            MutableLiveData(PersonApi.retrofitService.getProperties())
        }
    }
}