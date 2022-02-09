package com.gklabs.jlsampleapp.api

import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    companion object {
        const val PRODUCTS_LISTING_ENDPOINT = "/search/api/rest/v2/catalog/products/search/keyword"
        const val PRODUCT_DETAILS_ENDPOINT = "/mobile-apps/api/v1/products/"
        const val API_KEY = "AIzaSyDD_6O5gUgC4tRW5f9kxC0_76XRC8W7_mI"
        const val DEFAULT_SEARCH_QUERY = "dishwasher"
    }

    @GET(PRODUCTS_LISTING_ENDPOINT)
    suspend fun getProducts(
        @Query("q") query: String = DEFAULT_SEARCH_QUERY,
        @Query("key") apiKey: String = API_KEY
    ): ProductListResponse

    @GET(PRODUCT_DETAILS_ENDPOINT)
    suspend fun getProductDetails(): ProductDetailsResponse
}