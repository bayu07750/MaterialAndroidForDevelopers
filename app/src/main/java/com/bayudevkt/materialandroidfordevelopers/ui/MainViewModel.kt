package com.bayudevkt.materialandroidfordevelopers.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayudevkt.materialandroidfordevelopers.core.data.preferences.SettingPreferences
import com.bayudevkt.materialandroidfordevelopers.domain.model.SettingPreference
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.DarkModeSetting
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.FontSetting
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.LanguageSetting
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.ShapeSetting
import com.bayudevkt.materialandroidfordevelopers.ui.theme.DefaultSeedColor
import com.bayudevkt.materialandroidfordevelopers.ui.utils.toHex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

val defaultSettingPreference = SettingPreference(
    darkMode = DarkModeSetting.System.name,
    colorTheme = DefaultSeedColor.toHex(),
    systemTheme = false,
    shape = ShapeSetting.Rounded.name,
    font = FontSetting.Default.name,
    language = LanguageSetting.English.name,
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val settingPreferences: SettingPreferences,
) : ViewModel() {

    val settingPreference  = settingPreferences.readSettingPreference(defaultSettingPreference)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            defaultSettingPreference,
        )

    fun saveSettingPreference(settingPreference: SettingPreference) {
        viewModelScope.launch {
            settingPreferences.saveSettingPreference(settingPreference)
        }
    }
}