package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val productId: String,
    val title: String,
    val image: String,
    val price: Price
) : Parcelable