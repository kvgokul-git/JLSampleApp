package com.gklabs.jlsampleapp.domain

import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import com.gklabs.jlsampleapp.api.repositories.ProductRepository
import com.gklabs.jlsampleapp.network.NetworkApiRepositoryException
import com.gklabs.jlsampleapp.network.Type.Connection
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend fun execute(): UseCaseResult<ProductListResponse> =
        try {
            val products = productRepository.getProductList()
            UseCaseResult.SuccessResult(products)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }
}