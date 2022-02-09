package com.gklabs.jlsampleapp.model

import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse

sealed class ProductDetailsState {

    object Loading : ProductDetailsState()
    data class Loaded(
        val productDetailsResponse: ProductDetailsResponse
    ) : ProductDetailsState()

    object GenericError : ProductDetailsState()
    object NetworkError : ProductDetailsState()
}