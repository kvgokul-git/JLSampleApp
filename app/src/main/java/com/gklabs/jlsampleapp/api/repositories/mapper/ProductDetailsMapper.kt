package com.gklabs.jlsampleapp.api.repositories.mapper

import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object ProductDetailsMapper {

    @FromJson
    fun fromJson(productDetailsResponse: ProductDetailsResponse): ProductDetailsResponse =
        with(productDetailsResponse) {
            ProductDetailsResponse(
                title = title,
                media = media,
                price = price,
                details = details,
                displaySpecialOffer = displaySpecialOffer,
                additionalServices = additionalServices,
                code = code
            )
        }

    @Suppress("UNUSED_PARAMETER", "unused")
    @ToJson
    fun toJson(writer: JsonWriter, productDetailsResponse: ProductDetailsResponse) {
        throw UnsupportedOperationException()
    }
}