package com.gklabs.jlsampleapp.view.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gklabs.jlsampleapp.api.dto.Price
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.ui.theme.ComposeDemoTheme
import com.gklabs.jlsampleapp.view.utils.XSmallSpacer
import com.gklabs.jlsampleapp.view.utils.XXSmallSpacer
import com.gklabs.jlsampleapp.view.utils.image.CoilImage
import com.gklabs.jlsampleapp.view.utils.productForPreview


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCardShort(
    onProductClicked: (Product) -> Unit,
    product: Product,
    isMainScreen: Boolean
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(if (isMainScreen) 320.dp else 240.dp),
        onClick = { onProductClicked(product) }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            XXSmallSpacer()
            ProductTitle(title = product.title)
            XSmallSpacer()
            product.image?.let {
                CoilImage(
                    url = it,
                    contentDescription = "${product.title}, Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(240.dp)
                        .padding(top = 16.dp)
                )
            }
            ProductPrice(price = product.price)
            XSmallSpacer()

            if (isMainScreen) {
                ProductTeaser(product)
            }
        }
    }
}

@Composable
private fun ProductTeaser(
    product: Product
) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        XXSmallSpacer()

        Text(
            text = product.title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Text(
            text = product.productId,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .padding(horizontal = 16.dp)
                .align(Alignment.End)
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
                .padding(horizontal = 16.dp),
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

@Preview
@Composable
private fun PreviewLightCaseStudyCard() {
    ComposeDemoTheme(darkTheme = false) {
        ProductCardShort(
            onProductClicked = {},
            product = productForPreview,
            isMainScreen = true
        )
    }
}

@Preview
@Composable
private fun PreviewDarkCaseStudyCard() {
    ComposeDemoTheme(darkTheme = true) {
        ProductCardShort(
            onProductClicked = {},
            product = productForPreview,
            isMainScreen = true
        )
    }
}