package com.bayudevkt.materialandroidfordevelopers.core.data.preferences

import com.bayudevkt.materialandroidfordevelopers.domain.model.SettingPreference
import kotlinx.coroutines.flow.Flow

interface SettingPreferences {

    suspend fun saveSettingPreference(value: SettingPreference)

    fun readSettingPreference(default: SettingPreference): Flow<SettingPreference>
}