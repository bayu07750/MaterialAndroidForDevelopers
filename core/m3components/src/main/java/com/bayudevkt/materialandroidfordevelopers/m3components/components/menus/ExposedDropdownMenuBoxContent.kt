package com.bayudevkt.materialandroidfordevelopers.m3components.components.menus

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.m3components.utils.DataDummy

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxContent(
    modifier: Modifier = Modifier,
    languages: List<String> = remember { DataDummy.listProgrammingLanguages },
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf(languages.first()) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        ExposedDropdownMenuBox(
            modifier = modifier,
            expanded = expanded,
            onExpandedChange = { expanded = it },
            content = {
                OutlinedTextField(
                    modifier = Modifier
                        .menuAnchor(),
                    value = selectedLanguage,
                    onValueChange = {},
                    readOnly = true,
                    label = {
                        Text(text = "Most used programming language")
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    content = {
                        languages.forEach { language ->
                            DropdownMenuItem(
                                text = { Text(text = language) },
                                onClick = {
                                    selectedLanguage = language
                                    expanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                )
            },
        )
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewExposedDropdownMenuBox() {
    MaterialAndroidForDevelopersTheme {
        ExposedDropdownMenuBoxContent()
    }
}