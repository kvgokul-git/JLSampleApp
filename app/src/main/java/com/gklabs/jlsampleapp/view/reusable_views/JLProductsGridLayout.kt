package com.gklabs.jlsampleapp.view.reusable_views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gklabs.jlsampleapp.api.dto.Price
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.api.dto.ProductListResponse
import com.gklabs.jlsampleapp.view.JLAppNavigation

@ExperimentalFoundationApi
@Composable
fun JLProductsGrid(productListResponse: ProductListResponse, jlAppNavigation: JLAppNavigation) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            PageHeader(heading = "Products")
        }
        LazyVerticalGrid(
            cells = GridCells.Adaptive(150.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            items(productListResponse.products) { product ->
                JLProductGridItem(product = product, jlAppNavigation = jlAppNavigation)
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun JLProductGridItem(product: Product, jlAppNavigation: JLAppNavigation) {
    Card(modifier = Modifier
        .clickable {
            jlAppNavigation.navigateToProductDetailsScreen(product)
        }
        .padding(10.dp)
        .fillMaxWidth()
        .height(250.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
        }
        ProductTitle(title = product.title)
        XXSmallSpacer()
        CoilImage(url = product.image, contentDescription = product.productId)
        XXSmallSpacer()
        ProductPrice(price = product.price)
    }
}

@Composable
private fun PageHeader(heading: String?) {
    heading?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun ProductTitle(title: String?) {
    title?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun ProductPrice(price: Price?) {
    price?.let {
        Text(
            text = it.now,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(horizontal = 16.dp),
        )
    }
}



