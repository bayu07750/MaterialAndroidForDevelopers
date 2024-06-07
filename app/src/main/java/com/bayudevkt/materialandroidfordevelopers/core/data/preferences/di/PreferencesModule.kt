package com.bayudevkt.materialandroidfordevelopers.core.data.preferences.di

import com.bayudevkt.materialandroidfordevelopers.core.data.preferences.SettingPreferences
import com.bayudevkt.materialandroidfordevelopers.core.data.preferences.datastore.SettingPreferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class PreferencesModule {

    @Binds
    abstract fun bindSettingPreferencesDataStore(impl: SettingPreferencesDataStore): SettingPreferences
}