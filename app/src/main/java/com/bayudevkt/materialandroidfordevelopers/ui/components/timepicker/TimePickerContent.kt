package com.bayudevkt.materialandroidfordevelopers.ui.components.timepicker

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.KeyboardAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerContent(
    modifier: Modifier = Modifier,
) {
    var is24HourFormat by remember { mutableStateOf(false) }
    val state = rememberTimePickerState(is24Hour = is24HourFormat)
    val context = LocalContext.current
    var checked by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(top = 32.dp),
    ) {
        Text(text = "24 Hour Format", modifier = Modifier.align(Alignment.CenterHorizontally),)
        Switch(
            checked = is24HourFormat,
            onCheckedChange = { is24HourFormat = it },
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                TimeInput(state = state)
            } else {
                TimePicker(state = state)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconToggleButton(
                checked = checked,
                onCheckedChange = { checked = it },
                content = {
                    Icon(
                        imageVector = if (checked) {
                            Icons.Default.CalendarMonth
                        } else {
                            Icons.Default.KeyboardAlt
                        }, contentDescription = null
                    )
                }
            )
            Button(onClick = {
                val hour = state.hour
                val minute = state.minute
                Toast.makeText(context, "$hour, $minute", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Submit")
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewTimePickerContent() {
    MaterialAndroidForDevelopersTheme {
        TimePickerContent()
    }
}