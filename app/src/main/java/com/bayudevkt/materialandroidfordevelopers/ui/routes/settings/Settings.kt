package com.bayudevkt.materialandroidfordevelopers.ui.routes.settings

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BugReport
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.ColorLens
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.RoundedCorner
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.TextFields
import androidx.compose.material.icons.rounded.Translate
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.BuildConfig
import com.bayudevkt.materialandroidfordevelopers.R
import com.bayudevkt.materialandroidfordevelopers.ui.licenses.LicensesActivity
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.AppListItem
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.AppOutlinedListItem
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.FullRoundedCornerShape
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.defaultLargeTopAppBarColors
import com.bayudevkt.materialandroidfordevelopers.utils.openUrl

enum class SettingEnum {
    DARK_MODE,
    THEME,
    SHAPE,
    TEXT,
    LANGUAGE,
}

val SettingEnumSaver
    get() = listSaver<SettingEnum?, Any>(
        save = {
            listOf(it?.name ?: SettingEnum.DARK_MODE.name)
        },
        restore = {
            SettingEnum.valueOf(it[0] as String)
        }
    )

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SettingsDrawerContent(
    onCloseDrawer: () -> Unit,
    onClickedSettingItem: (SettingEnum) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    ModalDrawerSheet(
        modifier = modifier
            .navigationBarsPadding(),
        windowInsets = WindowInsets(0.dp)
    ) {
        TopAppBar(
            title = {
                Text(text = "Settings")
            },
            actions = {
                IconButton(onClick = onCloseDrawer) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = null
                    )
                }
            },
            colors = defaultLargeTopAppBarColors(),
        )

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(0.dp))
            AppListItem(
                title = stringResource(id = R.string.dark_mode),
                description = "",
                icon = Icons.Rounded.DarkMode,
                onClick = { onClickedSettingItem(SettingEnum.DARK_MODE) },
                shape = FullRoundedCornerShape,
                divider = false,
            )
            AppListItem(
                title = stringResource(id = R.string.theme),
                description = "",
                icon = Icons.Rounded.ColorLens,
                onClick = { onClickedSettingItem(SettingEnum.THEME) },
                shape = FullRoundedCornerShape,
                divider = false,
            )
            AppListItem(
                title = stringResource(id = R.string.shape),
                description = "",
                icon = Icons.Rounded.RoundedCorner,
                onClick = { onClickedSettingItem(SettingEnum.SHAPE) },
                shape = FullRoundedCornerShape,
                divider = false,
            )
            AppListItem(
                title = stringResource(id = R.string.text),
                description = "",
                icon = Icons.Rounded.TextFields,
                onClick = { onClickedSettingItem(SettingEnum.TEXT) },
                shape = FullRoundedCornerShape,
                divider = false,
            )
            AppListItem(
                title = stringResource(id = R.string.language),
                description = "",
                icon = Icons.Rounded.Language,
                onClick = {
//                    if (SDK_INT >= TIRAMISU) {
//                        val intent = Intent(ACTION_APP_LOCALE_SETTINGS).apply {
//                            data = Uri.fromParts("package", context.packageName, null)
//                        }
//                        context.startActivity(intent)
//                    } else {
//                        // Handle cases for older Android versions (provide instructions)
//                    }
                    onClickedSettingItem(SettingEnum.LANGUAGE)
                },
                shape = FullRoundedCornerShape,
                divider = false,
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            AppOutlinedListItem(
                title = stringResource(R.string.give_a_rating),
                description = stringResource(R.string.let_me_know_what_you_think),
                icon = Icons.Rounded.Star,
                onClick = {
                    val urlGooglePlay =
                        "https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
                    context.openUrl(urlGooglePlay)
                },
                divider = false,
                shape = FullRoundedCornerShape,
            )
            AppOutlinedListItem(
                title = stringResource(R.string.share),
                description = stringResource(R.string.share_the_app),
                icon = Icons.Rounded.Share,
                onClick = {
                    val urlGooglePlay =
                        "https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}"
                    Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Hey check out this app: $urlGooglePlay")
                        type = "text/plain"
                    }.also { intent ->
                        context.startActivity(Intent.createChooser(intent, null))
                    }
                },
                divider = false,
                shape = FullRoundedCornerShape,
            )
            AppOutlinedListItem(
                title = stringResource(R.string.report_bug),
                description = stringResource(R.string.report_a_bug),
                icon = Icons.Rounded.BugReport,
                onClick = {
                    val urlGithub = "https://github.com/bayu07750/MaterialAndroidForDevelopers/issues/new"
                    context.openUrl(urlGithub)
                },
                divider = false,
                shape = FullRoundedCornerShape,
            )
            AppOutlinedListItem(
                title = stringResource(R.string.help_translate),
                description = stringResource(R.string.help_translate_to_other_language),
                icon = Icons.Rounded.Translate,
                onClick = {
                    val urlGithub = "https://github.com/bayu07750/MaterialAndroidForDevelopers"
                    context.openUrl(urlGithub)
                },
                divider = false,
                shape = FullRoundedCornerShape,
            )
            AppOutlinedListItem(
                title = stringResource(R.string.source_code),
                description = stringResource(R.string.view_source_code),
                icon = Icons.Rounded.Code,
                onClick = {
                    val urlGithub = "https://github.com/bayu07750/MaterialAndroidForDevelopers"
                    context.openUrl(urlGithub)
                },
                divider = false,
                shape = FullRoundedCornerShape,
            )
            AppOutlinedListItem(
                title = stringResource(id = R.string.open_source_licenses),
                description = stringResource(R.string.view_open_source_licenses),
                icon = null,
                onClick = {
                    Intent(context, LicensesActivity::class.java).also { intent ->
                        context.startActivity(intent)
                    }
                },
                divider = false,
                shape = FullRoundedCornerShape,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "v${BuildConfig.VERSION_NAME}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsBottomSheet(
    setting: SettingEnum,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    settingsState: SettingsStateHolder = rememberSettingsStateHolder(),
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        dragHandle = {
            Surface(
                color = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.secondaryContainer),
                shadowElevation = 2.dp
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    BottomSheetDefaults.DragHandle()
                    TopAppBar(
                        title = {
                            val title = when (setting) {
                                SettingEnum.DARK_MODE -> stringResource(R.string.dark_mode)
                                SettingEnum.THEME -> stringResource(R.string.theme)
                                SettingEnum.SHAPE -> stringResource(R.string.shape)
                                SettingEnum.TEXT -> stringResource(R.string.text)
                                SettingEnum.LANGUAGE -> stringResource(R.string.language)
                            }
                            Text(text = title)
                        },
                        colors = defaultLargeTopAppBarColors(),
                    )
                }
            }
        },
    ) {
        when (setting) {
            SettingEnum.DARK_MODE -> {
                DarkModeSettingContent(
                    currentDarkModeSetting = settingsState.selectedDarkModeSetting,
                    onChangeDarkModeSetting = settingsState::onChangeDarkModeSetting
                )
            }

            SettingEnum.THEME -> {
                ThemeSetting(
                    currentSeedColor = settingsState.currentSeedColor,
                    onChangeSeedColor = settingsState::onChangeCurrentSeedColor,
                    useSystemTheme = settingsState.useSystemTheme,
                    onChangeUseSystemTHeme = settingsState::onChangeUseSystemTheme,
                    modifier = Modifier,
                )
            }

            SettingEnum.SHAPE -> {
                ShapeSettingContent(
                    currentShapeSetting = settingsState.shapeSetting,
                    onChangeShapeSetting = settingsState::onChangeShapeSetting
                )
            }

            SettingEnum.TEXT -> {
                TextSettingContent(
                    selectedFontSetting = settingsState.fontSetting,
                    onChangeFontSetting = settingsState::onChangeFontSetting,
                    modifier = Modifier,
                )
            }

            SettingEnum.LANGUAGE -> {
                LanguageSettingContent(
                    languageSetting = settingsState.languageSetting,
                    onChangeLanguageSetting = settingsState::onChangeLanguageSetting,
                    modifier = Modifier,
                )
            }
        }
    }
}
