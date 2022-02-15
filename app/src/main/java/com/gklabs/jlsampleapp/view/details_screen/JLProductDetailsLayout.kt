package com.gklabs.jlsampleapp.view.details_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gklabs.jlsampleapp.api.dto.Price
import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.view.reusable_views.CoilImage
import com.gklabs.jlsampleapp.view.reusable_views.LargeSpacer
import com.gklabs.jlsampleapp.view.reusable_views.MediumSpacer

@ExperimentalFoundationApi
@Composable
fun JLProductDetails(productDetailsResponse: ProductDetailsResponse) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ProductTitle(title = productDetailsResponse.title)
        productDetailsResponse.media?.images?.urls?.let {
            CoilImage(
                url = it?.first(),
                contentDescription = productDetailsResponse.code
            )
        }
        LargeSpacer()
        ProductDescription(description = productDetailsResponse.details?.productInformation)
        MediumSpacer()
        ProductPrice(price = productDetailsResponse.price)
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
private fun ProductDescription(description: String?) {
    description?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(horizontal = 12.dp)
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



