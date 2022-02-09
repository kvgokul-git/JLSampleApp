package com.gklabs.jlsampleapp.api.repositories.mapper

import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object ProductListMapper {

    @FromJson
    fun fromJson(productListResponse: ProductListResponse): List<Product> {
        return productListResponse.products.map { ProductMapper.fromJson(it) }
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: List<Product>?) {
        throw UnsupportedOperationException()
    }
}