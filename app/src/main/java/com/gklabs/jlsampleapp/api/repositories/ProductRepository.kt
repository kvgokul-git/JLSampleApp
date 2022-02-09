package com.gklabs.jlsampleapp.api.repositories

import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import com.gklabs.jlsampleapp.network.NetworkApiRepositoryException

interface ProductRepository {

    @Throws(NetworkApiRepositoryException::class)
    suspend fun getProductList(): ProductListResponse

    @Throws(NetworkApiRepositoryException::class, NoSuchElementException::class)
    suspend fun getProductDetails(productId: String): ProductDetailsResponse
}