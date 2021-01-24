package com.example.userapplication.network.rest.client


import com.example.userapplication.network.interceptor.TokenInterceptor
import com.example.userapplication.network.rest.dto.Category
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.Retrofit

import retrofit2.http.GET

private const val BASE_URL =
    "http://87.239.107.34/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder().addInterceptor(TokenInterceptor())
    .followRedirects(true)
    .followSslRedirects(true)
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(client)
    .baseUrl(BASE_URL)
    .build()

interface PersonApiService {
    @GET("all")
     suspend fun getProperties():
            List<Category>
}

object PersonApi {
    val retrofitService : PersonApiService by lazy {
        retrofit.create(
            PersonApiService::class.java) }
}