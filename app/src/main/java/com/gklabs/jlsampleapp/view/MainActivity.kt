package com.gklabs.jlsampleapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gklabs.jlsampleapp.model.ProductListState
import com.gklabs.jlsampleapp.ui.theme.JLSampleAppTheme
import com.gklabs.jlsampleapp.view.reusable_views.JLProductsGrid
import com.gklabs.jlsampleapp.view.reusable_views.JLStandardProgressBar
import com.gklabs.jlsampleapp.viewmodel.ProductDetailsViewModel
import com.gklabs.jlsampleapp.viewmodel.ProductDetailsViewModelFactory
import com.gklabs.jlsampleapp.viewmodel.ProductsListViewModel
import com.gklabs.jlsampleapp.viewmodel.ProductsListViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var productsListViewModelFactory: ProductsListViewModelFactory
    private val productsListViewModel: ProductsListViewModel by viewModels {
        productsListViewModelFactory
    }

    @Inject
    internal lateinit var productDetailsViewModelFactory: ProductDetailsViewModelFactory
    private val productDetailsViewModel: ProductDetailsViewModel by viewModels {
        productDetailsViewModelFactory
    }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JLSampleAppTheme {

                val navController = rememberNavController()
                val jlAppNavigation = JLAppNavigation(navController)

                NavHost(
                    navController = navController,
                    startDestination = Screen.ProductListing.route
                ) {
                    composable(route = Screen.ProductListing.route) {
                        DefaultSurface {
                            ProductsListWithViewModel(
                                jlAppNavigation = jlAppNavigation,
                                productsListViewModel
                            )
                        }
                    }
                    composable(
                        route = Screen.ProductDetails.route.plus("/{productId}"),
                        arguments = detailsScreenArguments
                    ) { navBackStackEntry ->

                        navBackStackEntry.arguments?.getString("productId")?.let {
                            DefaultSurface {
                                ProductDetailsWithViewModel(
                                    productDetailsViewModel = productDetailsViewModel,
                                    productId = it
                                )
                            }
                        }

                    }
                    composable(route = "search") {
                        Surface(color = MaterialTheme.colors.background) {
                            Text(text = "Search results screen")
                        }
                    }

                }

            }
        }
    }
}

// A surface container using the 'background' color from the theme
@Composable
fun DefaultSurface(content: @Composable () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        content.invoke()
    }
}

@ExperimentalFoundationApi
@Composable
fun ProductsListWithViewModel(
    jlAppNavigation: JLAppNavigation,
    productsListViewModel: ProductsListViewModel
) {
    val currentState: State<ProductListState> = productsListViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is ProductListState.Loaded -> JLProductsGrid(
            productListResponse = result.productListResponse,
            jlAppNavigation = jlAppNavigation
        )
        is ProductListState.Loading -> JLStandardProgressBar()
        else -> Text(text = " Hello there is an error")
        //todo handle other states
    }
}

@ExperimentalFoundationApi
@Composable
fun ProductDetailsWithViewModel(
    productDetailsViewModel: ProductDetailsViewModel,
    productId: String
) {
    Text(text = "Selected Product ID : ".plus(productId))
    //todo Debug the api call since we get network exception
    /*productDetailsViewModel.loadProductDetails(productId)
    val currentState: State<ProductDetailsState> =
        productDetailsViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is ProductDetailsState.Loaded -> JLProductDetails(
            productDetailsResponse = result.productDetailsResponse
        )
        is ProductDetailsState.Loading -> Text(text = "Loading...")
        else -> Text(
            text = " Hello there is an error with details screen",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onError
        )

    }*/
}