package com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun IconButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Camera")
        }
        IconButton(onClick = { /*TODO*/ }, enabled = false) {
            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Camera")
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun IconButtonPreview() {
    MaterialAndroidForDevelopersTheme {
        IconButtonContent()
    }
}