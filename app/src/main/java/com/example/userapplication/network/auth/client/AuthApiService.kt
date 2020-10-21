package com.example.userapplication.network.auth.client

import com.example.userapplication.network.auth.dto.LoginDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL =
    "http://192.168.0.31:8080/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .baseUrl(BASE_URL)
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