package com.example.userapplication.network.rest

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class PersonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request : Request = chain.request()

    }
}