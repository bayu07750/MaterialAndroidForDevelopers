package com.bayudevkt.materialandroidfordevelopers.m3components.components.dialog

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.bayudevkt.materialandroidfordevelopers.m3components.utils.DataDummy

/**
 * BasicAlertDialog
 */

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicAlertDialogContent(
    modifier: Modifier = Modifier,
    data: List<String> = remember { DataDummy.listProgrammingLanguages }
) {
    var dialogOpen by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = {
            dialogOpen = true
        }) {
            Text(text = "Show Dialog")
        }
    }

    if (dialogOpen) {
        var selectedLanguage by remember {
            mutableStateOf(DataDummy.listProgrammingLanguages.first())
        }

        BasicAlertDialog(
            onDismissRequest = {
                dialogOpen = false
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            )
        ) {
            Surface(
                modifier = Modifier
                    .heightIn(max = 500.dp),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation,
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "What is your favorite programming language?")
                    Divider()
                    Column(
                        modifier = Modifier
                            .verticalScroll(
                                state = rememberScrollState(),
                            )
                            .weight(1f)
                            .selectableGroup(),
                    ) {
                        data.forEach { language ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = selectedLanguage == language,
                                        onClick = {
                                            selectedLanguage = language
                                        }
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                RadioButton(
                                    selected = selectedLanguage == language,
                                    onClick = {
                                        selectedLanguage = language
                                    },
                                )
                                Text(text = language.uppercase(), style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                    Divider()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        val context = LocalContext.current
                        TextButton(onClick = {
                            Toast.makeText(context, selectedLanguage, Toast.LENGTH_SHORT).show()
                            dialogOpen = false
                        }) {
                            Text(text = "Ok")
                        }
                    }
                }
            }
        }
    }
}
/* endregion */