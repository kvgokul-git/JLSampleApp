package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductListResponse(
    val products: List<Product>
) : Parcelable