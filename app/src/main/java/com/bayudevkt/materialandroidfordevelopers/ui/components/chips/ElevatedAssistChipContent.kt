package com.bayudevkt.materialandroidfordevelopers.ui.components.chips

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun ElevatedAssistChipContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        ElevatedAssistChip(
            onClick = {
                Toast.makeText(context, "Elevated Assist", Toast.LENGTH_SHORT).show()
            },
            label = {
                Text(text = "Assist")
            },
        )
        ElevatedAssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            }
        )
        ElevatedAssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(Icons.Rounded.Check, null)
            }
        )
        ElevatedAssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(Icons.Rounded.Check, null)
            },
            enabled = false,
        )
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewElevatedAssistChipContent() {
    MaterialAndroidForDevelopersTheme {
        ElevatedAssistChipContent()
    }
}