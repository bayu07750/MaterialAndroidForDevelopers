package com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun OutlinedIconButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedIconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Location")
        }
        OutlinedIconButton(onClick = { /*TODO*/ }, enabled = false) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Location")
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewOutlinedIconButton() {
    MaterialAndroidForDevelopersTheme {
        OutlinedIconButtonContent()
    }
}