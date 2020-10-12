package com.example.userapplication.network.dto

import com.squareup.moshi.Json

data class Person(
    val name: String,
    val lastName: String,
    val about: String
)