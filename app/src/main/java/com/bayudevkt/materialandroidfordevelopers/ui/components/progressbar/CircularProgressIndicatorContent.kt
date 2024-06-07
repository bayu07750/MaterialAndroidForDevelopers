package com.bayudevkt.materialandroidfordevelopers.ui.components.progressbar

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import kotlin.math.abs

/* region */
@Composable
fun CircularProgressIndicatorContent(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(24.dp))

            var progress by remember { mutableFloatStateOf(0.2f) }
            val progressAnim by animateFloatAsState(targetValue = progress, label = "Progress")
            Box(modifier = Modifier.size(100.dp)) {
                CircularProgressIndicator(
                    progress = { progressAnim },
                    modifier = Modifier.matchParentSize(),
                    strokeWidth = 15.dp,
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                FilledTonalIconButton(onClick = {
                    if (progress >= 1f) return@FilledTonalIconButton
                    progress += 0.1f
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
                FilledTonalIconButton(onClick = {
                    if (progress <= 0.0f) return@FilledTonalIconButton
                    progress -= 0.1f
                }) {
                    Icon(imageVector = Icons.Default.HorizontalRule, contentDescription = "Min")
                }
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewCircularProgressIndicatorContent() {
    MaterialAndroidForDevelopersTheme {
        CircularProgressIndicatorContent()
    }
}