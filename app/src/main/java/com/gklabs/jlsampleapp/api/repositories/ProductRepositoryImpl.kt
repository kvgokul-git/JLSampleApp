package com.gklabs.jlsampleapp.api.repositories

import com.gklabs.jlsampleapp.api.ProductsApi
import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.network.NetworkApiCallDelegate
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi,
    private val networkApiCallDelegate: NetworkApiCallDelegate
) : ProductRepository, NetworkApiCallDelegate by networkApiCallDelegate {

    override suspend fun getProductList() =
        executeApiCall { productsApi.getProducts() }

    override suspend fun getProductDetails(productId: String): ProductDetailsResponse =
        executeApiCall { productsApi.getProductDetails(productId = productId) }

}