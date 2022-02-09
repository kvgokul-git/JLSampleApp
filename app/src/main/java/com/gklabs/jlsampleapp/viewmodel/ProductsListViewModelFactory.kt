package com.gklabs.jlsampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gklabs.jlsampleapp.domain.ProductsUseCase
import javax.inject.Inject

class ProductsListViewModelFactory @Inject constructor(
    private val productsUseCase: ProductsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        @Suppress("UNCHECKED_CAST")
        return ProductsListViewModel(productsUseCase) as T
    }
}