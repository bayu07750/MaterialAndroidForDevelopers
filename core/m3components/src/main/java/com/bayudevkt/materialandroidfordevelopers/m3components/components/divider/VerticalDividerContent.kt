package com.bayudevkt.materialandroidfordevelopers.m3components.components.divider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
fun VerticalDividerContent(
    modifier: Modifier = Modifier,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(),) {
        var thickness by remember { mutableFloatStateOf(0f) }
        Text(text = "Divider: $thickness")
        Spacer(modifier = Modifier.height(8.dp))
        VerticalDivider(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp),
            thickness = thickness.dp,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Change the thickness: ")
        Slider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = thickness,
            onValueChange = { thickness = it },
            valueRange = 1f..15f,
            steps = 15,
        )
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewVerticalDividerContent() {
    MaterialAndroidForDevelopersTheme {
        VerticalDividerContent()
    }
}