package com.bayudevkt.materialandroidfordevelopers.m3components.components.datepicker

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import com.bayudevkt.materialandroidfordevelopers.m3components.utils.DateHelper

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val dateRangeState = rememberDateRangePickerState(
            yearRange = 2000..2045,
            initialDisplayMode = DisplayMode.Picker,
        )
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 4.dp,
            modifier = Modifier
                .weight(1f)
        ) {
            DateRangePicker(
                state = dateRangeState,
                modifier = Modifier,
                showModeToggle = true,
            )
        }
        val context = LocalContext.current
        Button(onClick = {
            val startDate = DateHelper.formatTime(dateRangeState.selectedStartDateMillis)
            val endDate = DateHelper.formatTime(dateRangeState.selectedEndDateMillis)
            Toast.makeText(context, "$startDate-$endDate", Toast.LENGTH_LONG).show()
        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Select Date")
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewDateRangePickerContent() {
    MaterialAndroidForDevelopersTheme {
        DateRangePickerContent()
    }
}