package com.gklabs.jlsampleapp.view.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import com.gklabs.jlsampleapp.model.SelectionState

@Composable
fun ProductsHorizontalRow(
    productListResponse: ProductListResponse,
    onSelectProduct: (Product) -> Unit,
    selectedProduct: Product
) {
    LazyRow(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(start = 16.dp)
    ) {
        items(productListResponse.products.size) { product ->
            val selectionState =
                if (selectedProduct.productId == product.toString()) SelectionState.Selected else SelectionState.Unselected
            ProductCardMini(
                product = selectedProduct,
                onSelectProduct = onSelectProduct,
                selectionState = selectionState
            )
        }
    }
}