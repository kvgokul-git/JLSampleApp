package com.gklabs.jlsampleapp.api.repositories.mapper

import com.gklabs.jlsampleapp.api.dto.Product
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object ProductMapper {

    @FromJson
    fun fromJson(product: Product): Product {
        with(product) {
            return Product(
                productId = productId,
                title = title,
                image = image,
                price = price
            )
        }
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: Product?) {
        throw UnsupportedOperationException()
    }
}