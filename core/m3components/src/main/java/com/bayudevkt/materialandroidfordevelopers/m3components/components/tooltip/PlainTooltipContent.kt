package com.bayudevkt.materialandroidfordevelopers.m3components.components.tooltip

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import kotlinx.coroutines.launch

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlainTooltipContent(
    modifier: Modifier = Modifier,
) {
    val tooltipState = rememberTooltipState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip(
                        caretProperties = TooltipDefaults.caretProperties,

                    ) {
                        Text(text = "Hello World!")
                    }
                },
                state = tooltipState,
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Press me!")
                }
            }
            Button(onClick = {
                scope.launch {
                    tooltipState.show()
                }
            }) {
                Text(text = "Show tooltip")
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewPlainTooltipContent() {
    MaterialAndroidForDevelopersTheme {
        PlainTooltipContent()
    }
}