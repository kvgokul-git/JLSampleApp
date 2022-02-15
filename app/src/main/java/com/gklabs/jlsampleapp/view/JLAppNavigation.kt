package com.gklabs.jlsampleapp.view

import androidx.navigation.NavController
import com.gklabs.jlsampleapp.api.dto.Product

class JLAppNavigation(
    private val navController: NavController
) {
    fun navigateToProductDetailsScreen(product: Product) {
        navController.navigate(Screen.ProductDetails.withArgs(product.productId))
    }
}