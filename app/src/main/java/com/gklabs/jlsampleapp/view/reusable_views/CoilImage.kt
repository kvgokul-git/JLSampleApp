package com.gklabs.jlsampleapp.view.reusable_views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.gklabs.jlsampleapp.R
import com.gklabs.jlsampleapp.ui.theme.JLSampleAppTheme

@ExperimentalFoundationApi
@Composable
fun CoilImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    val painter = rememberImagePainter(
        data = "https:".plus(url),
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
@ExperimentalFoundationApi
@Composable
private fun PreviewLightCoilImage() {
    JLSampleAppTheme(darkTheme = false) {
        CoilImage(
            url = "test",
            contentDescription = null
        )
    }
}

@Preview
@ExperimentalFoundationApi
@Composable
private fun PreviewDarkCoilImage() {
    JLSampleAppTheme(darkTheme = true) {
        CoilImage(
            url = "test",
            contentDescription = null
        )
    }
}