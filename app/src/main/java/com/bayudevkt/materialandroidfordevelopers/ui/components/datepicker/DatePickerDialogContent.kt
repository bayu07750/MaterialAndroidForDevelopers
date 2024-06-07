package com.bayudevkt.materialandroidfordevelopers.ui.components.datepicker

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.utils.DateHelper
import java.util.Calendar

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogContent(
    modifier: Modifier = Modifier,
) {
    var openDialog by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            openDialog = true
        }) {
            Text(text = "Show Date Picker")
        }
    }

    if (openDialog) {
        val datePickerState = rememberDatePickerState()
        val context = LocalContext.current
        DatePickerDialog(
            onDismissRequest = { openDialog = false },
            confirmButton = {
                Button(onClick = {
                    val selectedDate = DateHelper.formatTime(datePickerState.selectedDateMillis)
                    Toast.makeText(context, selectedDate, Toast.LENGTH_SHORT).show()
                    openDialog = false
                }) {
                    Text(text = "Submit")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog = false
                }) {
                    Text(text = "Cancel")
                }
            },
            content = {
                DatePicker(
                    state = datePickerState,
                )
            }
        )
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewDatePickerDialogContent() {
    MaterialAndroidForDevelopersTheme {
        DatePickerDialogContent()
    }
}