package com.bayudevkt.materialandroidfordevelopers.ui.theme

import androidx.compose.runtime.Composable
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingsStateHolder
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.Shapes
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.Typography
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.isDarkTheme
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.rememberSettingsStateHolder
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

@Composable
fun MaterialAndroidForDevelopersTheme(
    settingsStateHolder: SettingsStateHolder = rememberSettingsStateHolder(),
    content: @Composable () -> Unit
) {
    MaterialAndroidForDevelopersTheme(
        darkTheme = settingsStateHolder.isDarkTheme,
        seedColor = settingsStateHolder.currentSeedColor,
        dynamicColor = settingsStateHolder.useSystemTheme,
        shapes = settingsStateHolder.Shapes,
        typography = settingsStateHolder.Typography,
        content = content,
    )
}
