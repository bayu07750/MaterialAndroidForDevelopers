package com.bayudevkt.materialandroidfordevelopers.ui.routes.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.R
import kotlinx.collections.immutable.toImmutableList

enum class DarkModeSetting(@StringRes val label: Int, val icon: ImageVector) {
    Light(label = R.string.light, icon = Icons.Rounded.LightMode),
    Dark(label = R.string.dark, icon = Icons.Rounded.DarkMode),
    System(label = R.string.system, icon = Icons.Rounded.Android)
}

val DarkModeSettingSaver
    get() = listSaver<DarkModeSetting, Any>(
        save = {
            listOf(it.name)
        },
        restore = {
            DarkModeSetting.valueOf(it.first() as String)
        }
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DarkModeSettingContent(
    currentDarkModeSetting: DarkModeSetting,
    onChangeDarkModeSetting: (DarkModeSetting) -> Unit,
    modifier: Modifier = Modifier,
) {
    val options = remember { DarkModeSetting.entries.toImmutableList() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, option ->
                val selected = currentDarkModeSetting == option
                SegmentedButton(
                    selected = selected,
                    onClick = {
                        onChangeDarkModeSetting(option)
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    icon = {
                        Icon(
                            imageVector = option.icon,
                            contentDescription = null,
                        )
                    }
                ) {
                    Text(text = stringResource(id = option.label))
                }
            }
        }
    }
}