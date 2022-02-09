package com.gklabs.jlsampleapp.view.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import com.gklabs.jlsampleapp.ui.theme.ComposeDemoTheme
import com.gklabs.jlsampleapp.view.utils.SmallSpacer
import com.gklabs.jlsampleapp.view.utils.productListForPreview
import com.gklabs.jlsampleapp.view.utils.productListResponseForPreview

@Composable
fun ProductsListScreen(
    onProductClicked: (Product) -> Unit,
    productListResponse: ProductListResponse,
    initialProduct: Product = productListResponse.products.first()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val selectedProduct = remember { mutableStateOf(initialProduct) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SearchInput()
            SmallSpacer()
            ScreenTitle("Products")
            SmallSpacer()
            val onSelectProduct: (Product) -> Unit = { product ->
                selectedProduct.value = product
            }
            ProductsHorizontalRow(productListResponse, onSelectProduct, selectedProduct.value)
            SmallSpacer()
            ProductCardShort(onProductClicked, selectedProduct.value, true)

        }
    }
}

@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "search icon",
                modifier = Modifier
                    .size(18.dp)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview
@Composable
private fun PreviewLightStudiesListScreen() {
    ComposeDemoTheme(darkTheme = false) {
        ProductsListScreen(
            onProductClicked = {},
            productListResponse = productListResponseForPreview
        )
    }
}

@Preview
@Composable
private fun PreviewDarkStudiesListScreen() {
    ComposeDemoTheme(darkTheme = true) {
        ProductsListScreen(
            onProductClicked = {},
            productListResponse = productListResponseForPreview
        )
    }
}