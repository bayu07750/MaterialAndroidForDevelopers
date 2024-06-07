package com.bayudevkt.materialandroidfordevelopers.ui.components.chips

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.AssistChip
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
fun AssistsChipContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        AssistChip(
            onClick = {
                Toast.makeText(context, "Assist Chip", Toast.LENGTH_SHORT).show()
            },
            label = {
                Text(text = "Assist")
            },
        )
        AssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            }
        )
        AssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Assist")
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
        AssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Assist")
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
fun PreviewAssistsChipContent() {
    MaterialAndroidForDevelopersTheme {
        AssistsChipContent()
    }
}