package com.example.userapplication.network.interceptor

import android.content.Context
import com.example.userapplication.preferences.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = AppPreferences.getAccessToken()
        return chain.proceed(chain.request().newBuilder().addHeader("Authorization", token!!).build())
    }
}