package com.example.userapplication.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.userapplication.network.auth.client.AuthApi
import com.example.userapplication.network.auth.dto.LoginDto
import com.example.userapplication.preferences.AppPreferences
import kotlinx.coroutines.*

class UserViewModel (application: Application) : AndroidViewModel(application){
    var viewModelJob = Job()
    val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)
    var authenticated : MutableLiveData<Boolean> = MutableLiveData(false)

    fun authenticate(username:String, password:String) {
      coroutineScope.launch {
          try{
              val token: String =  AuthApi.retrofitService.authenticate(LoginDto(username,password))
              AppPreferences.setAccessToken("Bearer $token")
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