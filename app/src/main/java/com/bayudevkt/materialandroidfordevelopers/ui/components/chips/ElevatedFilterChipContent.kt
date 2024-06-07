package com.bayudevkt.materialandroidfordevelopers.ui.components.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.Tv
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ElevatedFilterChipContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = "Choose your interests")
        var selected1 by remember { mutableStateOf(false) }
        var selected2 by remember { mutableStateOf(false) }
        var selected3 by remember { mutableStateOf(false) }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ElevatedFilterChip(
                selected = selected1,
                onClick = {
                    selected1 = !selected1
                },
                label = {
                    Text(text = "TV")
                },
            )
            ElevatedFilterChip(
                selected = selected2,
                onClick = {
                    selected2 = !selected2
                },
                label = {
                    Text(text = "Movie")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Movie,
                        contentDescription = null
                    )
                }
            )
            ElevatedFilterChip(
                selected = selected3,
                onClick = {
                    selected3 = !selected3
                },
                label = {
                    Text(text = "Both")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Movie,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Tv,
                        contentDescription = null
                    )
                }
            )
            ElevatedFilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text(text = "Other")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Favorite,
                        contentDescription = null
                    )
                },
                enabled = false,
            )
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewElevatedFilterChipContent() {
    MaterialAndroidForDevelopersTheme {
        ElevatedFilterChipContent()
    }
}