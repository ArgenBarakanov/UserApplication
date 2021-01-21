package com.example.userapplication.network.auth.client

import com.example.userapplication.network.auth.dto.LoginDto
import com.example.userapplication.network.interceptor.RedirectInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL =
    "http://87.239.107.34/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .followRedirects(true)
    .followSslRedirects(true)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface AuthApiService {
    @POST("auth/signin")
    suspend fun authenticate(@Body loginDto: LoginDto):String
}

object AuthApi{
    val retrofitService : AuthApiService by lazy {
        retrofit.create(
            AuthApiService::class.java) }
}