package com.bayudevkt.materialandroidfordevelopers.ui.components.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.utils.DataDummy
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
data class DataCheckbox(
    val label: String,
    val initialChecked: Boolean,
) {
    var checked by mutableStateOf(initialChecked)
}

@Composable
fun CheckBoxExampleContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val programmingLanguages = remember {
            DataDummy.listProgrammingLanguages.take(5).map {
                DataCheckbox(it, false)
            }
        }
        Text(text = "What is your favorite programming language?", style = MaterialTheme.typography.titleMedium)
        programmingLanguages.forEach { data ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = data.checked,
                        onClick = { data.checked = !data.checked },
                        role = Role.Checkbox
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = data.checked,
                    onCheckedChange = { data.checked = it }
                )
                Text(text = data.label)
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewCheckboxExampleContent() {
    MaterialAndroidForDevelopersTheme {
        CheckBoxExampleContent()
    }
}