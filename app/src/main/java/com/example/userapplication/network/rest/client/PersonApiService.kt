package com.example.userapplication.network.rest.client


import com.example.userapplication.network.auth.dto.LoginDto
import com.example.userapplication.network.rest.dto.Person
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.Retrofit
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL =
    "http://192.168.0.31:8080/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PersonApiService {
    @GET("all")
    suspend fun getProperties():
           List<Person>
}

object PersonApi {
    val retrofitService : PersonApiService by lazy {
        retrofit.create(
            PersonApiService::class.java) }
}