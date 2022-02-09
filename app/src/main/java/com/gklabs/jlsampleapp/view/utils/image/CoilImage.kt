package com.gklabs.jlsampleapp.view.utils.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.gklabs.jlsampleapp.R
import com.gklabs.jlsampleapp.ui.theme.ComposeDemoTheme

@Composable
fun CoilImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            crossfade(true)
            placeholder(R.drawable.image_place_holder)
        }
    )
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
    )
}



@Preview
@Composable
private fun PreviewLightCoilImage() {
    ComposeDemoTheme(darkTheme = false) {
        CoilImage(
            url = "test",
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun PreviewDarkCoilImage() {
    ComposeDemoTheme(darkTheme = true) {
        CoilImage(
            url = "test",
            contentDescription = null
        )
    }
}