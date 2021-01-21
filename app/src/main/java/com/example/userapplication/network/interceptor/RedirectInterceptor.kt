package com.example.userapplication.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class RedirectInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}