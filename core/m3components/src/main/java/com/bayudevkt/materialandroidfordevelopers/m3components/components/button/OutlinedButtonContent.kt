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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun OutlinedButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Button")
        }
        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Button")
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            enabled = false,
        ) {
            Text(text = "Button Disabled")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Save, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Button with Icon")
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewOutlinedButtonContent() {
    MaterialAndroidForDevelopersTheme {
        OutlinedButtonContent()
    }
}