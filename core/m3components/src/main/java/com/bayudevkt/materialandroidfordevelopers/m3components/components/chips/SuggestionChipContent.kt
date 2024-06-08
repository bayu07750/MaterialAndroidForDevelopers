package com.bayudevkt.materialandroidfordevelopers.m3components.components.chips

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun SuggestionChipContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        SuggestionChip(
            onClick = {
                Toast.makeText(context, "Assist Chip", Toast.LENGTH_SHORT).show()
            },
            label = {
                Text(text = "Suggestion")
            },
        )
        SuggestionChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Suggestion")
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
        )
        SuggestionChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Suggestion")
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
            enabled = false,
        )
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewSuggestionChipContent() {
    MaterialAndroidForDevelopersTheme {
        SuggestionChipContent()
    }
}