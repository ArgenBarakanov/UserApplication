package com.example.userapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.network.rest.client.PersonApi
import com.example.userapplication.network.auth.dto.LoginDto
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel : ViewModel() {


     var username : MutableLiveData<String> = MutableLiveData()
     var password : MutableLiveData<String> = MutableLiveData()


    fun login(username:String, password:String) {
        Log.i("MainViewModel","Data is: " + username + " " + password);
        viewModelScope.launch {
            try{
            PersonApi.retrofitService.authenticate(LoginDto(username,password))
            }catch (e:Exception){
                Log.e("MainViewModel","Error is: " + e.message)
            }
        }
    }
}