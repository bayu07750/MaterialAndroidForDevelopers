package com.bayudevkt.materialandroidfordevelopers.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SettingPreference(
    val darkMode: String,
    val colorTheme: String, // #DEDEDE
    val systemTheme: Boolean,
    val shape: String,
    val font: String,
    val language: String,
    val paletteStyle: String,
)