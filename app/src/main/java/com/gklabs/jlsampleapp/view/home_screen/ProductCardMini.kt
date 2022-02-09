package com.gklabs.jlsampleapp.view.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.gklabs.jlsampleapp.api.dto.Product
import com.gklabs.jlsampleapp.model.SelectionState
import com.gklabs.jlsampleapp.ui.theme.ComposeDemoTheme
import com.gklabs.jlsampleapp.view.utils.productForPreview

@Composable
fun ProductCardMini(
    product: Product,
    onSelectProduct: (Product) -> Unit,
    selectionState: SelectionState
) {
    val modifier = if (selectionState == SelectionState.Selected) {
        Modifier.background(MaterialTheme.colors.secondaryVariant)
    } else Modifier
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .clickable { onSelectProduct(product) }
            .size(136.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
        ) {
            Image(
                painter = rememberImagePainter(product.image),
                contentDescription = "${product.title}, Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .clip(CircleShape)
            )

            Text(
                text = product.title ?: "Title",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            )
        }
    }
}


@Preview
@Composable
private fun PreviewDarkCaseStudyCard() {
    ComposeDemoTheme(darkTheme = true) {
        ProductCardMini(
            product = productForPreview,
            onSelectProduct = {},
            selectionState = SelectionState.Unselected
        )
    }
}

@Preview
@Composable
private fun PreviewLightCaseStudyCard() {
    ComposeDemoTheme(darkTheme = false) {
        ProductCardMini(
            product = productForPreview,
            onSelectProduct = {},
            selectionState = SelectionState.Unselected
        )
    }
}