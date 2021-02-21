package com.example.userapplication.network.rest.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val title: String,
    val price: Double,
    val imageSrcUrl: String?
) : Parcelable