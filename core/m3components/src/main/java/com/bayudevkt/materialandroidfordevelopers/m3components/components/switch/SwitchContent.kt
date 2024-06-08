package com.bayudevkt.materialandroidfordevelopers.m3components.components.switch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun SwitchContent(
    modifier: Modifier = Modifier,
) {
    var darkTheme by remember { mutableStateOf(false) }
    MaterialAndroidForDevelopersTheme(
        darkTheme = darkTheme
    ) {
        Surface {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Switch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = !darkTheme },
                    thumbContent = {
                        Icon(
                            imageVector = if (darkTheme) Icons.Default.DarkMode else Icons.Default.LightMode,
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                )
                Switch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = !darkTheme },
                    thumbContent = {
                        Icon(
                            imageVector = if (darkTheme) Icons.Default.DarkMode else Icons.Default.LightMode,
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp)
                        )
                    },
                    enabled = false
                )
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewSwitchContent() {
    MaterialAndroidForDevelopersTheme {
        SwitchContent()
    }
}