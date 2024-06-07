package com.bayudevkt.materialandroidfordevelopers.ui.components.datepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import java.util.Calendar

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Surface(
            tonalElevation = 3.dp
        ) {
            val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            DatePicker(
                state = datePickerState,
                modifier = modifier,
            )
        }
        Surface(
            tonalElevation = 3.dp
        ) {
            val currentTimeInMills = remember {
                Calendar.getInstance().timeInMillis
            }
            val yearRange = 2000..20445
            val datePickerState = rememberDatePickerState(
                yearRange = yearRange,
                initialSelectedDateMillis = currentTimeInMills
            )
            DatePicker(
                state = datePickerState,
                modifier = modifier,
                showModeToggle = false,
            )
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewDatePickerContent() {
    MaterialAndroidForDevelopersTheme {
        DatePickerContent()
    }
}