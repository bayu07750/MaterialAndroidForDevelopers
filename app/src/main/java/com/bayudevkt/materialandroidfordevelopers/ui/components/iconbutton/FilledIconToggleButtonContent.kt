package com.bayudevkt.materialandroidfordevelopers.ui.components.iconbutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun FilledIconToggleButtonContent(
    modifier: Modifier = Modifier,
) {
    var darkMode by remember { mutableStateOf(false) }

    MaterialAndroidForDevelopersTheme(
        darkTheme = darkMode,
        dynamicColor = false,
    ) {
        Surface {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = "Dark Mode: $darkMode")
                FilledIconToggleButton(
                    checked = darkMode,
                    onCheckedChange = { darkMode = it },
                ) {
                    Icon(
                        imageVector = if (darkMode)
                            Icons.Default.DarkMode else
                            Icons.Default.LightMode,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewFilledIconToggleButtonContent() {
    MaterialAndroidForDevelopersTheme {
        FilledIconToggleButtonContent()
    }
}