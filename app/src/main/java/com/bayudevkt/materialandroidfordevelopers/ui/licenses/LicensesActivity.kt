package com.bayudevkt.materialandroidfordevelopers.ui.licenses

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bayudevkt.materialandroidfordevelopers.R
import com.bayudevkt.materialandroidfordevelopers.ui.MainViewModel
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.defaultLargeTopAppBarColors
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.rememberSettingsStateHolder
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.ui.utils.LargeTopAppBarWithBackButton
import com.mikepenz.aboutlibraries.ui.compose.m3.LibrariesContainer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LicensesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun App() {
    val context = LocalContext.current
    val viewModel: MainViewModel = hiltViewModel()
    val settingPreference by viewModel.settingPreference.collectAsStateWithLifecycle()
    val settingsStateHolder = rememberSettingsStateHolder(
        settingPreference = settingPreference,
        onChangeSettingPreference = viewModel::saveSettingPreference
    )
    MaterialAndroidForDevelopersTheme(
        settingsStateHolder = settingsStateHolder
    ) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold(
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.secondaryContainer),
                    shadowElevation = 2.dp
                ) {
                    LargeTopAppBar(
                        title = {
                            Text(text = stringResource(R.string.open_source_licenses))
                        },
                        navigationIcon = {
                            IconButton(onClick = { (context as Activity).finish() }) {
                                Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = null)
                            }
                        },
                        scrollBehavior = scrollBehavior,
                        colors = defaultLargeTopAppBarColors(),
                    )
                }
            }
        ) { innerPadding ->
            LibrariesContainer(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                showAuthor = true,
                showVersion = false,
                showLicenseBadges = true,
            )
        }
    }
}