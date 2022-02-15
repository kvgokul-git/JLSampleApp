package com.gklabs.jlsampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.domain.ProductDetailsUseCase
import com.gklabs.jlsampleapp.domain.UseCaseResult
import com.gklabs.jlsampleapp.model.ProductDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val productDetailsUseCase: ProductDetailsUseCase
) : ViewModel() {

    private val _viewState: MutableStateFlow<ProductDetailsState> =
        MutableStateFlow(ProductDetailsState.Loading)
    val viewState: StateFlow<ProductDetailsState> = _viewState

    fun loadProductDetails(product: String) {
        viewModelScope.launch {
            _viewState.value =
                when (val result = productDetailsUseCase.execute(product)) {
                    is UseCaseResult.SuccessResult -> ProductDetailsState.Loaded(
                        result.value
                    )
                    is UseCaseResult.NetworkErrorResult -> ProductDetailsState.NetworkError
                    is UseCaseResult.GenericErrorResult -> ProductDetailsState.GenericError
                }
        }
    }
}