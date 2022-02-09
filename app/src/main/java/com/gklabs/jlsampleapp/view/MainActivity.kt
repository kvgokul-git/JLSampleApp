package com.gklabs.jlsampleapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.model.ProductListState
import com.gklabs.jlsampleapp.model.ProductDetailsState
import com.gklabs.jlsampleapp.ui.theme.ComposeDemoTheme
import com.gklabs.jlsampleapp.view.utils.reusable_views.JLStandardProgressBar
import com.gklabs.jlsampleapp.view.details_screen.ProductDetailsScreen
import com.gklabs.jlsampleapp.view.home_screen.ProductsListScreen
import com.gklabs.jlsampleapp.viewmodel.ProductsListViewModel
import com.gklabs.jlsampleapp.viewmodel.ProductsListViewModelFactory
import com.gklabs.jlsampleapp.viewmodel.ProductDetailsViewModel
import com.gklabs.jlsampleapp.viewmodel.ProductDetailsViewModelFactory
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {

                val navController = rememberNavController()
                val jlAppNavigation = JLAppNavigation(navController)

                NavHost(
                    navController = navController,
                    startDestination = Screen.ProductListing.route
                ) {
                    composable(route = Screen.ProductListing.route) {
                        DefaultSurface {
                            ProductsListWithViewModel(
                                jlAppNavigation.navigateToProductDetailsScreen,
                                productsListViewModel
                            )
                        }
                    }
                    /*composable(
                        route = Screen.ProductDetails.route + "/{id}/{title}/{client}/{vertical}/{heroImageUrl}",
                        arguments = detailsScreenArguments
                    ) { navBackStackEntry ->

                        navBackStackEntry.getProduct?.let { caseStudy ->
                            DefaultSurface {
                                StudyDetailsWithViewModel(
                                    productDetailsViewModel,
                                    caseStudy
                                )
                            }
                        }
                    }*/
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

@Composable
fun ProductsListWithViewModel(
    onProductClicked: (Product) -> Unit,
    productsListViewModel: ProductsListViewModel
) {
    val currentState: State<ProductListState> = productsListViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is ProductListState.Loaded -> ProductsListScreen(
            onProductClicked = onProductClicked,
            productListResponse = result.productListResponse
        )
        is ProductListState.Loading -> JLStandardProgressBar()
        else -> Text(text = " Hello there is an error")
        //todo handle other states
    }
}

@Composable
fun ProductDetailsWithViewModel(
    productDetailsViewModel: ProductDetailsViewModel,
    selectedProduct: Product
) {
    productDetailsViewModel.loadProductDetails(selectedProduct)

    val currentState: State<ProductDetailsState> =
        productDetailsViewModel.viewState.collectAsState()
    when (val result = currentState.value) {
        is ProductDetailsState.Loaded -> ProductDetailsScreen(
            productDetailsResponse = result.productDetailsResponse
        )
        is ProductDetailsState.Loading -> Text(text = "Loading...")
        else -> Text(
            text = " Hello there is an error with details screen",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onError
        )
        //todo handle other states
    }
}