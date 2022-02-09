package com.gklabs.jlsampleapp.model

import com.gklabs.jlsampleapp.api.dto.ProductListResponse

sealed class ProductListState {

    object Loading : ProductListState()
    data class Loaded(
        val productListResponse: ProductListResponse
    ) : ProductListState()

    object GenericError : ProductListState()
    object NetworkError : ProductListState()
}