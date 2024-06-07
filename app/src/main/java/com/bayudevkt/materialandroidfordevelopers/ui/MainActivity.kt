package com.bayudevkt.materialandroidfordevelopers.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.navigation.material3Graph
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingEnum
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingEnumSaver
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingsBottomSheet
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingsDrawerContent
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingsStateHolder
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.rememberSettingsStateHolder
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
private fun App(
    modifier: Modifier = Modifier,
) {
    val viewModel: MainViewModel = hiltViewModel()
    val settingPreferenceState by viewModel.settingPreference.collectAsStateWithLifecycle()
    val settingsStateHolder = rememberSettingsStateHolder(
        settingPreference = settingPreferenceState,
        onChangeSettingPreference = viewModel::saveSettingPreference
    )

    MaterialAndroidForDevelopersTheme(
        settingsStateHolder = settingsStateHolder
    ) {
        App(
            settingsStateHolder = settingsStateHolder,
            modifier = modifier,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    modifier: Modifier = Modifier,
    settingsStateHolder: SettingsStateHolder = rememberSettingsStateHolder(),
) {
    val coroutineScope = rememberCoroutineScope()

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    var selectedSettingItem by rememberSaveable(stateSaver = SettingEnumSaver) { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()


    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            SettingsDrawerContent(
                onCloseDrawer = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                },
                onClickedSettingItem = { enum ->
                    showBottomSheet = true
                    selectedSettingItem = enum
                }
            )
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = Material3Route
        ) {
            material3Graph(
                navController = navController,
                onSettings = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                },
                settingsStateHolder = settingsStateHolder,
            )
        }
    }

    if (showBottomSheet && selectedSettingItem != null) {
        SettingsBottomSheet(
            sheetState = sheetState,
            setting = selectedSettingItem!!,
            onDismissRequest = {
                showBottomSheet = false
                selectedSettingItem = null
            },
            settingsState = settingsStateHolder,
        )
    }
}

@Serializable
data object Material3Route

@Serializable
data object TypographyRoute

@Serializable
data object Material3Colors

@Serializable
data object Material3ComponentsRoute

@Serializable
data class Material3ComponentDetailRoute(
    val componentTitle: String
)

@Serializable
data object GenerateColorsRoute