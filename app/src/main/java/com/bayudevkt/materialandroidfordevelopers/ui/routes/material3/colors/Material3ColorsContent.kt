package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.colors

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.utils.toHex

/**
 * Colors
 */

data class ColorData(
    val label: String,
    val color: Color,
    val contentColor: Color,
)

@Composable
fun rememberMaterial3Colors(colorScheme: ColorScheme): List<ColorData> {
    return remember(colorScheme) {
        listOf(
            ColorData("Primary", colorScheme.primary, colorScheme.onPrimary),
            ColorData("On Primary", colorScheme.onPrimary, colorScheme.primary),
            ColorData("Primary Container", colorScheme.primaryContainer, colorScheme.onPrimaryContainer),
            ColorData("On Primary Container", colorScheme.onPrimaryContainer, colorScheme.primaryContainer),
            ColorData("Secondary", colorScheme.secondary, colorScheme.onSecondary),
            ColorData("On Secondary", colorScheme.onSecondary, colorScheme.secondary),
            ColorData("Secondary Container", colorScheme.secondaryContainer, colorScheme.onSecondaryContainer),
            ColorData("On Secondary Container", colorScheme.onSecondaryContainer, colorScheme.secondaryContainer),
            ColorData("Tertiary", colorScheme.tertiary, colorScheme.onTertiary),
            ColorData("On Tertiary", colorScheme.onTertiary, colorScheme.tertiary),
            ColorData("Tertiary Container", colorScheme.tertiaryContainer, colorScheme.onTertiaryContainer),
            ColorData("On Tertiary Container", colorScheme.onTertiaryContainer, colorScheme.tertiaryContainer),
            ColorData("Error", colorScheme.error, colorScheme.onError),
            ColorData("On Error", colorScheme.onError, colorScheme.error),
            ColorData("Error Container", colorScheme.errorContainer, colorScheme.onErrorContainer),
            ColorData("On Error Container", colorScheme.onErrorContainer, colorScheme.errorContainer),
            ColorData("Background", colorScheme.background, colorScheme.onBackground),
            ColorData("On Background", colorScheme.onBackground, colorScheme.background),
            ColorData("Surface", colorScheme.surface, colorScheme.onSurface),
            ColorData("On Surface", colorScheme.onSurface, colorScheme.surface),
            ColorData("Surface Variant", colorScheme.surfaceVariant, colorScheme.onSurfaceVariant),
            ColorData("On Surface Variant", colorScheme.onSurfaceVariant, colorScheme.surfaceVariant),
            ColorData("Outline", colorScheme.outline, colorScheme.onError),
        )
    }
}

@Composable
fun Material3ColorsContent(
    modifier: Modifier = Modifier,
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
) {
    val colors = rememberMaterial3Colors(colorScheme)
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(colors) { _, item ->
            Material3ColorItem(item)
        }
    }
}

@Composable
fun Material3ColorItem(item: ColorData, modifier: Modifier = Modifier,) {
    Surface(
        color = item.color,
        contentColor = item.contentColor,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .heightIn(min = 150.dp),
        ) {
            Text(
                text = item.label,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = remember(item.color) { item.color.toHex() },
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}