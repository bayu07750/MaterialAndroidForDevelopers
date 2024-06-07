package com.bayudevkt.materialandroidfordevelopers.core.data.preferences.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bayudevkt.materialandroidfordevelopers.core.data.preferences.SettingPreferences
import com.bayudevkt.materialandroidfordevelopers.core.di.AppDispatcher
import com.bayudevkt.materialandroidfordevelopers.core.di.Dispatcher
import com.bayudevkt.materialandroidfordevelopers.domain.model.SettingPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settingsPrefenrece")

@Singleton
class SettingPreferencesDataStore @Inject constructor(
    @ApplicationContext private val context: Context,
    private val json: Json,
    @Dispatcher(AppDispatcher.Default) private val dispatcher: CoroutineDispatcher,
) : SettingPreferences {

    companion object {
        private val SETTING_PREFERENCE_KEY = stringPreferencesKey("setting_preference")
    }

    override suspend fun saveSettingPreference(value: SettingPreference) {
        val json = withContext(dispatcher) {
            json.encodeToString(value)
        }
        Timber.d("saveSettingPreference; value; $json")
        context.dataStore.edit { preferences ->
            preferences[SETTING_PREFERENCE_KEY] = json
        }
    }

    override fun readSettingPreference(default: SettingPreference): Flow<SettingPreference> {
        return context.dataStore.data.map { preferences ->
            val settingPreferenceJson = preferences[SETTING_PREFERENCE_KEY] ?: ""
            Timber.d("readSettingPreference; value; $settingPreferenceJson")
            if (settingPreferenceJson.isEmpty()) {
                default
            } else {
                json.decodeFromString<SettingPreference>(settingPreferenceJson)
            }
        }
            .flowOn(dispatcher)
    }
}