package com.gklabs.jlsampleapp.api.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDetailsResponse(
    val title: String,
    val media: Media?,
    val price: Price,
    val details: Details?,
    val displaySpecialOffer: String,
    val additionalServices: AdditionalServices?,
    val code: String
) : Parcelable