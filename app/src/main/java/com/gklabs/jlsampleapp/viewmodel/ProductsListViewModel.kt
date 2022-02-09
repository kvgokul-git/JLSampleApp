package com.gklabs.jlsampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gklabs.jlsampleapp.domain.ProductsUseCase
import com.gklabs.jlsampleapp.domain.UseCaseResult
import com.gklabs.jlsampleapp.model.ProductListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsListViewModel(
    private val productsUseCase: ProductsUseCase
) : ViewModel() {
    private val _viewState: MutableStateFlow<ProductListState> =
        MutableStateFlow(ProductListState.Loading)
    val viewState: StateFlow<ProductListState> = _viewState

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            _viewState.value = when (val result = productsUseCase.execute()) {
                is UseCaseResult.SuccessResult -> ProductListState.Loaded(result.value)
                is UseCaseResult.NetworkErrorResult -> ProductListState.NetworkError
                is UseCaseResult.GenericErrorResult -> ProductListState.GenericError
            }
        }
    }
}