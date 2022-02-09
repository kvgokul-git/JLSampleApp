package com.gklabs.jlsampleapp.view

import androidx.navigation.NavType
import androidx.navigation.navArgument

private const val PRODUCT_ID_KEY = "productId"

sealed class Screen(val route: String) {
    object ProductListing : Screen("productlisting")
    object ProductDetails : Screen("productdetails")

    fun withArgs(vararg args: String?): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}

val detailsScreenArguments = listOf(
    navArgument(PRODUCT_ID_KEY) {
        type = NavType.StringType
        defaultValue = 1
    }
)

/*val NavBackStackEntry.getProduct: Product?
    get() = arguments?.let {
        Product(
            productId = it.getString(PRODUCT_ID_KEY)
        )
    }*/
