package com.gklabs.jlsampleapp.domain

import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.api.repositories.ProductRepository
import com.gklabs.jlsampleapp.network.NetworkApiRepositoryException
import com.gklabs.jlsampleapp.network.Type.Connection
import javax.inject.Inject

class ProductDetailsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    suspend fun execute(productId: String): UseCaseResult<ProductDetailsResponse> =
        try {
            val productDetails = productRepository.getProductDetails(productId)
            UseCaseResult.SuccessResult(productDetails)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        } catch (throwable: Throwable) {
            UseCaseResult.GenericErrorResult
        }
}