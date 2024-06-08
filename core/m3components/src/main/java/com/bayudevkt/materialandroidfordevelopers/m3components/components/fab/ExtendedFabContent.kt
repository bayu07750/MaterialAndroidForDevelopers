package com.bayudevkt.materialandroidfordevelopers.m3components.components.fab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun ExtendedFabContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ExtendedFloatingActionButton(
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Camera"
                )
            }
            ,
            text = {
                Text(text = "Compose")
            }
        )
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewExtendedFabContent() {
    MaterialAndroidForDevelopersTheme {
        ExtendedFabContent()
    }
}