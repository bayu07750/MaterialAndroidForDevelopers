package com.bayudevkt.materialandroidfordevelopers.ui.components.iconbutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun FilledTonalIconButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FilledTonalIconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.DarkMode, contentDescription = "Location")
        }
        FilledTonalIconButton(onClick = { /*TODO*/ }, enabled = false) {
            Icon(imageVector = Icons.Default.DarkMode, contentDescription = "Location")
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewFilledTonalIconButton() {
    MaterialAndroidForDevelopersTheme {
        FilledTonalIconButtonContent()
    }
}