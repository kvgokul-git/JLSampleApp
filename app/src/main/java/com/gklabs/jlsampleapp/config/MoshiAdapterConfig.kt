package com.gklabs.jlsampleapp.config

import com.gklabs.jlsampleapp.api.repositories.mapper.ProductDetailsMapper
import com.gklabs.jlsampleapp.api.repositories.mapper.ProductListMapper
import com.gklabs.jlsampleapp.api.repositories.mapper.ProductMapper
import com.squareup.moshi.Moshi

/**
 * Internal function that provides Moshi setup with all required mappers for use in both the
 * Network modules and unit tests.
 */
object MoshiAdapterConfig {
    fun getMoshiConfig(): Moshi =
        Moshi.Builder()
            .addProductMappers()
            .build()

    private fun Moshi.Builder.addProductMappers() =
        this.add(ProductMapper)
            .add(ProductListMapper)
            .add(ProductDetailsMapper)
}
