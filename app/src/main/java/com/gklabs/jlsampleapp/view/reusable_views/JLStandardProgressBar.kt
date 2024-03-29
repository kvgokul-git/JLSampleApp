package com.gklabs.jlsampleapp.view.reusable_views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.gklabs.jlsampleapp.ui.theme.JLSampleAppTheme


@Composable
fun JLStandardProgressBar() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.Green
            )
        }

    }
}

@Preview
@Composable
private fun PreviewLightStandardProgressBar() {
    JLSampleAppTheme(darkTheme = false) {

        JLStandardProgressBar()
    }
}

@Preview
@Composable
private fun PreviewDarkStandardProgressBar() {
    JLSampleAppTheme(darkTheme = true) {
        JLStandardProgressBar()
    }
}