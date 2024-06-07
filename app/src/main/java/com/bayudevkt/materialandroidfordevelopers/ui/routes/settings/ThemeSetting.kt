package com.bayudevkt.materialandroidfordevelopers.ui.routes.settings

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.S
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.R
import com.bayudevkt.materialandroidfordevelopers.ui.theme.AndroidSeedColor
import com.bayudevkt.materialandroidfordevelopers.ui.theme.DefaultSeedColor
import com.bayudevkt.materialandroidfordevelopers.ui.theme.KotlinSeedColor
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ThemeSetting(
    currentSeedColor: Color,
    onChangeSeedColor: (Color) -> Unit,
    useSystemTheme: Boolean,
    onChangeUseSystemTHeme: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val availableSeedColors = remember {
        listOf(
            "Default" to DefaultSeedColor,
            "Android" to AndroidSeedColor,
            "Kotlin" to KotlinSeedColor
        ).toImmutableList()
    }
    val currentContentColor = LocalContentColor.current
    val disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
    val shouldDisabledThemeColorContentColor =
        if (useSystemTheme) disabledContentColor else currentContentColor
    val enabledFollowTheme = remember { SDK_INT >= S }
    val disabledThemeFollowSystemContentColor = if (enabledFollowTheme) currentContentColor else disabledContentColor
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier
                        .weight(1F)
                ) {
                    Text(
                        text = stringResource(R.string.system_theme),
                        style = MaterialTheme.typography.titleMedium.copy(color = disabledThemeFollowSystemContentColor)
                    )
                    Text(
                        text = stringResource(R.string.theme_will_follow_your_wallpaper),
                        style = MaterialTheme.typography.bodyMedium.copy(color =  disabledThemeFollowSystemContentColor)
                    )
                }
                Switch(
                    checked = useSystemTheme,
                    onCheckedChange = { onChangeUseSystemTHeme(it) },
                    enabled = enabledFollowTheme,
                    colors = SwitchDefaults.colors()
                )
            }
        }

        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = stringResource(R.string.theme_color),
                    style = MaterialTheme.typography.titleMedium.copy(color = shouldDisabledThemeColorContentColor)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectableGroup(),
                ) {
                    availableSeedColors.forEach { (name, color) ->
                        val selectedColor = currentSeedColor == color
                        val interactionSource = remember {
                            MutableInteractionSource()
                        }
                        ListItem(
                            modifier = Modifier
                                .selectable(
                                    selected = selectedColor,
                                    interactionSource = interactionSource,
                                    role = Role.RadioButton,
                                    indication = LocalIndication.current,
                                    onClick = {
                                        onChangeSeedColor(color)
                                    },
                                    enabled = !useSystemTheme,
                                ),
                            headlineContent = {
                                Text(text = name, color = shouldDisabledThemeColorContentColor)
                            },
                            trailingContent = {
                                RadioButton(
                                    selected = selectedColor,
                                    onClick = { },
                                    colors = RadioButtonDefaults.colors(
                                        disabledSelectedColor = shouldDisabledThemeColorContentColor,
                                        disabledUnselectedColor = shouldDisabledThemeColorContentColor,
                                    ),
                                    enabled = !useSystemTheme,
                                )
                            },
                            colors = ListItemDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewThemeSetting() {
    MaterialAndroidForDevelopersTheme {
        ThemeSetting(
            currentSeedColor = DefaultSeedColor,
            useSystemTheme = false,
            onChangeUseSystemTHeme = {},
            onChangeSeedColor = {}
        )
    }
}