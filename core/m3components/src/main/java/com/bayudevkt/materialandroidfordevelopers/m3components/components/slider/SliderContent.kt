package com.bayudevkt.materialandroidfordevelopers.m3components.components.slider

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun SliderContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        var value by remember { mutableFloatStateOf(0f) }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Slider(
                value = value,
                onValueChange = { value = it },
                valueRange = 1f..100f,
                steps = 0,
            )
            Text(text = "Value: ${Math.round(value)}")
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewSliderContent() {
    MaterialAndroidForDevelopersTheme {
        SliderContent()
    }
}