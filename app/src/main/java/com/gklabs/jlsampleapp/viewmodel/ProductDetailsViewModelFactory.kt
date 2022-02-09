package com.gklabs.jlsampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gklabs.jlsampleapp.domain.ProductDetailsUseCase
import javax.inject.Inject

class ProductDetailsViewModelFactory @Inject constructor(
    private val productDetailsUseCase: ProductDetailsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        ProductDetailsViewModel(productDetailsUseCase) as T
}