package com.bayudevkt.materialandroidfordevelopers.ui.components.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun TriStateCheckBoxContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val items = remember {
            List(5) {
                DataCheckbox(label = (it + 1).toString(), initialChecked = false)
            }
        }

        val parentState = remember(
            keys = items.map { it.checked }.toTypedArray()
        ) {
            when {
                items.all { it.checked } -> ToggleableState.On
                items.none { it.checked } -> ToggleableState.Off
                else -> ToggleableState.Indeterminate
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    items.forEach {
                        it.checked = newState
                    }
                }
            )
            Text(text = "Numbers")
        }
        Column(
            modifier = Modifier.padding(start = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .toggleable(
                            value = item.checked,
                            role = Role.Checkbox,
                            onValueChange = { item.checked = it }
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Checkbox(
                        checked = item.checked,
                        onCheckedChange = { item.checked = it }
                    )
                    Text(text = item.label)
                }
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewTriStateCheckBoxContent() {
    MaterialAndroidForDevelopersTheme {
        TriStateCheckBoxContent()
    }
}