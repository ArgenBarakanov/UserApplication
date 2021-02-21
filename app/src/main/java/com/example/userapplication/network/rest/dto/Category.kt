package com.example.userapplication.network.rest.dto

data class Category(
    val name: String,
    val products: List<Product>
)