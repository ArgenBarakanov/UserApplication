package com.example.userapplication.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

object AppPreferences {
    private var sharedPreferences: SharedPreferences? = null

    fun setup(context: Context) {
        sharedPreferences = context.getSharedPreferences("USER_API_PREFERENCES",MODE_PRIVATE)
    }

    fun getAccessToken(): String? {
       return sharedPreferences?.getString("ACCESS_TOKEN","")
    }

    fun setAccessToken(token: String) {
        sharedPreferences?.edit()?.putString("ACCESS_TOKEN", token)?.apply()
    }

}