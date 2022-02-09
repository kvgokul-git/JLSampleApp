package com.gklabs.jlsampleapp.view.details_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gklabs.jlsampleapp.api.dto.ProductDetailsResponse
import com.gklabs.jlsampleapp.ui.theme.ComposeDemoTheme
import com.gklabs.jlsampleapp.view.utils.image.CoilImage
import com.gklabs.jlsampleapp.view.home_screen.ProductCardShort
import com.gklabs.jlsampleapp.view.home_screen.ScreenTitle
import com.gklabs.jlsampleapp.view.utils.SmallSpacer
import com.gklabs.jlsampleapp.view.utils.XXSmallSpacer
import com.gklabs.jlsampleapp.view.utils.productDetailsResponseForPreview

@Composable
fun ProductDetailsScreen(
    productDetailsResponse: ProductDetailsResponse
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            /*items(listOf(product)) { caseStudy ->
                ProductCardShort(
                    onProductClicked = {},
                    product = caseStudy,
                    isMainScreen = false
                )
            }
            items(productDetailsResponse.sections) { section ->
                ComposeCaseSection(section)
            }*/
        }
    }
}

/*@Composable
private fun ComposeCaseSection(section: CaseStudySection) {
    section.title?.let {
        ScreenTitle(title = it)
    }
    SmallSpacer()
    section.body.forEach { body ->
        when (body) {
            is CaseStudyBody.BodyText -> {
                Text(text = body.value)
            }
            is CaseStudyBody.BodyImage -> {
                CoilImage(
                    url = body.value,
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(240.dp)
                        .padding(top = 16.dp)
                )
            }
        }
        XXSmallSpacer()

    }
    SmallSpacer()
}*/

@Preview
@Composable
private fun PreviewLightStudyDetailsScreen() {
    ComposeDemoTheme(darkTheme = false) {
        ProductDetailsScreen(
            productDetailsResponse = productDetailsResponseForPreview
        )
    }
}

@Preview
@Composable
private fun PreviewDarkStudyDetailsScreen() {
    ComposeDemoTheme(darkTheme = true) {
        ProductDetailsScreen(
            productDetailsResponse = productDetailsResponseForPreview
        )
    }
}