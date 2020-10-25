package com.example.userapplication.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.network.auth.client.AuthApi
import com.example.userapplication.network.auth.dto.LoginDto
import kotlinx.coroutines.*

class UserViewModel (application: Application) : AndroidViewModel(application){
    var viewModelJob = Job()
    val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)
    var authenticated : MutableLiveData<Boolean> = MutableLiveData(false)

    fun authenticate(username:String, password:String) {
      coroutineScope.launch {
          try{
              val token: String =  AuthApi.retrofitService.authenticate(LoginDto(username,password))
              Log.i("UserViewModel","Access Token is: " + token)
              val preferences : SharedPreferences = getApplication<Application>().getSharedPreferences("USER_API_PREFERENCES",Context.MODE_PRIVATE)
              preferences.edit().putString("ACCESS_TOKEN",token).apply()
              authenticated.postValue(true)
          }catch (e:Exception){
              e.printStackTrace()
          }
      }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}