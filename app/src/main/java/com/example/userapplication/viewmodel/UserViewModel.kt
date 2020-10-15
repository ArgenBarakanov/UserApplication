package com.example.userapplication.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.network.MarsApi
import com.example.userapplication.network.dto.LoginDto
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    fun authenticate(username:String, password:String) {
      val token =viewModelScope.launch {
          try{
               MarsApi.retrofitService.authenticate(LoginDto(username,password))
          }catch (e:Exception){
              Log.e("MainViewModel","Error is: " + e.message)
          }
      }
    }
}