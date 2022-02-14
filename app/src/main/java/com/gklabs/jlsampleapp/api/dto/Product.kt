package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "productId") val productId: String,
    @Json(name = "title") val title: String,
    @Json(name = "image") val image: String,
    @Json(name = "price") val price: Price
) : Parcelable