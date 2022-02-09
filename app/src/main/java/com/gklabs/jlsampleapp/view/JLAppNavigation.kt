package com.gklabs.jlsampleapp.view

import androidx.navigation.NavController
import com.gklabs.jlsampleapp.api.dto.Product

class JLAppNavigation(
    private val navController: NavController
) {
    val navigateToProductDetailsScreen: (Product) -> Unit
        get() = { product ->
            navController.navigate(
                Screen.ProductDetails.withArgs(
                    product.productId
                )
            )
        }
}