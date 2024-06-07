package com.bayudevkt.materialandroidfordevelopers.ui.routes.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.R
import kotlinx.collections.immutable.toImmutableList

enum class LanguageSetting(val code: String, @StringRes val label: Int) {
    English(code = "en", label = R.string.english),
    Indonesian(code = "id", label = R.string.indonesia)
}

@Composable
fun LanguageSettingContent(
    languageSetting: LanguageSetting,
    onChangeLanguageSetting: (LanguageSetting) -> Unit,
    modifier: Modifier = Modifier,
) {
    val options = remember {
        LanguageSetting.entries.toImmutableList()
    }
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .selectableGroup(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        options.forEachIndexed { _, option ->
            val selectedColor = languageSetting == option
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
                            onChangeLanguageSetting(option)
                        }
                    ),
                headlineContent = {
                    Text(text = stringResource(id = option.label))
                },
                trailingContent = {
                    RadioButton(
                        selected = selectedColor,
                        onClick = { },
                    )
                },
                colors = ListItemDefaults.colors()
            )
        }
    }
}