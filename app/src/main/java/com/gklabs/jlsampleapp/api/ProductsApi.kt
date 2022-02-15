package com.gklabs.jlsampleapp.api

import com.gklabs.jlsampleapp.BuildConfig
import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductsApi {

    companion object {
        const val PRODUCTS_LISTING_ENDPOINT = "/search/api/rest/v2/catalog/products/search/keyword"
        const val PRODUCT_DETAILS_ENDPOINT = "/mobile-apps/api/v1/products/"
        const val DEFAULT_USER_AGENT = "PostmanRuntime/7.29.0"
        const val DEFAULT_SEARCH_QUERY = "dishwasher"
    }

    @GET(PRODUCTS_LISTING_ENDPOINT)
    suspend fun getProducts(
        @Header("User-Agent") agent: String = DEFAULT_USER_AGENT,
        @Query("q") query: String = DEFAULT_SEARCH_QUERY,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): ProductListResponse

    @GET(PRODUCT_DETAILS_ENDPOINT)
    suspend fun getProductDetails(
        @Header("User-Agent") agent: String = DEFAULT_USER_AGENT,
        @Path("productId") productId: String
    ): ProductDetailsResponse
}