package com.bayudevkt.materialandroidfordevelopers.m3components.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun ElevatedButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Button")
        }
        ElevatedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Button")
        }
        ElevatedButton(
            onClick = { /*TODO*/ },
            enabled = false,
        ) {
            Text(text = "Button Disabled")
        }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Save, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Button with Icon")
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewElevatedButtonContent() {
    MaterialAndroidForDevelopersTheme {
        ElevatedButtonContent()
    }
}