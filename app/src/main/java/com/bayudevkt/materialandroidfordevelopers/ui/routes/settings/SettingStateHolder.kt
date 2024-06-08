package com.bayudevkt.materialandroidfordevelopers.ui.routes.settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.os.LocaleListCompat
import com.bayudevkt.materialandroidfordevelopers.domain.model.SettingPreference
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.CutShape
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.DancingScriptTypography
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.DefaultSeedColor
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.DefaultTypography
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MontserratTypography
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.NoneShape
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.PoppinsTypography
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.RobotoTypography
import com.bayudevkt.materialandroidfordevelopers.ui.utils.toHex
import timber.log.Timber

@Composable
fun rememberSettingsStateHolder(
    settingPreference: SettingPreference,
    onChangeSettingPreference: (SettingPreference) -> Unit = {},
): SettingsStateHolder {
    return rememberSettingsStateHolder(
        initialDarkModeSetting = DarkModeSetting.valueOf(settingPreference.darkMode),
        initialSeedColor = remember(settingPreference.colorTheme) {
            Color(settingPreference.colorTheme.replace(oldValue = "#", newValue = "FF").toLong(16)).also {
                Timber.d("rememberSettingsStateHolder; ${it.toHex()}")
            }
        },
        initialUseSystemTheme = settingPreference.systemTheme,
        initialShapeSetting = ShapeSetting.valueOf(settingPreference.shape),
        initialFontSetting = FontSetting.valueOf(settingPreference.font),
        initialLanguageSetting = LanguageSetting.valueOf(settingPreference.language),
        onChangeSettingPreference = onChangeSettingPreference
    )
}

@Composable
fun rememberSettingsStateHolder(
    initialDarkModeSetting: DarkModeSetting = DarkModeSetting.System,
    initialSeedColor: Color = DefaultSeedColor,
    initialUseSystemTheme: Boolean = false,
    initialShapeSetting: ShapeSetting = ShapeSetting.Rounded,
    initialFontSetting: FontSetting = FontSetting.Default,
    initialLanguageSetting: LanguageSetting = LanguageSetting.English,
    onChangeSettingPreference: (SettingPreference) -> Unit = {},
): SettingsStateHolder {
    val onChangeSettingPreferenceUpdated by rememberUpdatedState(onChangeSettingPreference)
    return rememberSaveable(
        initialDarkModeSetting,
        initialSeedColor,
        initialUseSystemTheme,
        initialShapeSetting,
        initialFontSetting,
        initialLanguageSetting,
        saver = SettingsStateHolder.Saver,
    ) {
        SettingsStateHolder(
            initialDarkModeSetting = initialDarkModeSetting,
            initialSeedColor = initialSeedColor,
            initialUseSystemTheme = initialUseSystemTheme,
            initialShapeSetting = initialShapeSetting,
            initialFontSetting = initialFontSetting,
            initialLanguageSetting = initialLanguageSetting,
            onChangeSettingPreference = onChangeSettingPreferenceUpdated,
        )
    }
}

class SettingsStateHolder(
    initialDarkModeSetting: DarkModeSetting,
    initialSeedColor: Color,
    initialUseSystemTheme: Boolean,
    initialShapeSetting: ShapeSetting,
    initialFontSetting: FontSetting,
    initialLanguageSetting: LanguageSetting,
    private val onChangeSettingPreference: (SettingPreference) -> Unit
) {

    var selectedDarkModeSetting by mutableStateOf(initialDarkModeSetting)
        private set

    var currentSeedColor by mutableStateOf(initialSeedColor)
        private set

    var useSystemTheme by mutableStateOf(initialUseSystemTheme)
        private set

    var shapeSetting by mutableStateOf(initialShapeSetting)
        private set

    var fontSetting by mutableStateOf(initialFontSetting)
        private set

    var languageSetting by mutableStateOf(initialLanguageSetting)
        private set

    private val settingPreference
        get() = SettingPreference(
            darkMode = selectedDarkModeSetting.name,
            colorTheme = currentSeedColor.toHex(),
            systemTheme = useSystemTheme,
            shape = shapeSetting.name,
            font = fontSetting.name,
            language = languageSetting.name,
        )

    fun onChangeDarkModeSetting(value: DarkModeSetting) {
        selectedDarkModeSetting = value
        onChangeSettingPreference(settingPreference.copy(darkMode = value.name))
    }

    fun onChangeCurrentSeedColor(value: Color) {
        currentSeedColor = value
        onChangeSettingPreference(settingPreference.copy(colorTheme = value.toHex()))
    }

    fun onChangeUseSystemTheme(value: Boolean) {
        useSystemTheme = value
        onChangeSettingPreference(settingPreference.copy(systemTheme = value))
    }

    fun onChangeShapeSetting(value: ShapeSetting) {
        shapeSetting = value
        onChangeSettingPreference(settingPreference.copy(shape = value.name))
    }

    fun onChangeFontSetting(value: FontSetting) {
        fontSetting = value
        onChangeSettingPreference(settingPreference.copy(font = value.name))
    }

    fun onChangeLanguageSetting(value: LanguageSetting) {
        languageSetting = value
        onChangeSettingPreference(settingPreference.copy(language = value.name))

        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(value.code))
    }

    companion object {
        val Saver = listSaver<SettingsStateHolder, Any>(
            save = {
                listOf(
                    it.selectedDarkModeSetting.name,
                    it.currentSeedColor.red,
                    it.currentSeedColor.green,
                    it.currentSeedColor.blue,
                    it.useSystemTheme,
                    it.shapeSetting.name,
                    it.fontSetting.name,
                    it.languageSetting.name
                )
            },
            restore = {
                SettingsStateHolder(
                    initialDarkModeSetting = DarkModeSetting.valueOf(it[0] as String),
                    initialSeedColor = Color(
                        red = it[1] as Float,
                        green = it[2] as Float,
                        blue = it[3] as Float,
                    ),
                    initialUseSystemTheme = it[4] as Boolean,
                    initialShapeSetting = ShapeSetting.valueOf(it[5] as String),
                    initialFontSetting = FontSetting.valueOf(it[6] as String),
                    initialLanguageSetting = LanguageSetting.valueOf(it[7] as String),
                    onChangeSettingPreference = {},
                )
            }
        )
    }
}

val SettingsStateHolder.isDarkTheme
    @Composable
    get() = when (selectedDarkModeSetting) {
        DarkModeSetting.Light -> false
        DarkModeSetting.Dark -> true
        DarkModeSetting.System -> isSystemInDarkTheme()
    }

val SettingsStateHolder.Shapes
    @Composable
    get() = when (shapeSetting) {
        ShapeSetting.Rounded -> MaterialTheme.shapes
        ShapeSetting.Cut -> CutShape
        ShapeSetting.None -> NoneShape
    }

val SettingsStateHolder.Typography
    @Composable
    get() = when (fontSetting) {
        FontSetting.Default -> DefaultTypography
        FontSetting.Roboto -> RobotoTypography
        FontSetting.Poppins -> PoppinsTypography
        FontSetting.Montserrat -> MontserratTypography
        FontSetting.DancingScript -> DancingScriptTypography
    }