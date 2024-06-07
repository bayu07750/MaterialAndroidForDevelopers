package com.bayudevkt.materialandroidfordevelopers.ui.components.navigationrail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun NavigationRailContent(
    modifier: Modifier = Modifier,
) {
    val items = remember {
        listOf(
            Icons.Default.Home to "Home",
            Icons.Default.FavoriteBorder to "Favorite",
            Icons.Default.Settings to "Settings",
        )
    }
    var selectedItem by remember { mutableStateOf(items.first().second) }

    Row(
        modifier = modifier
            .fillMaxSize(),
    ) {
        NavigationRail(
            header = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            }
        ) {
            items.forEach { item ->
                NavigationRailItem(
                    selected = item.second == selectedItem,
                    onClick = {
                        selectedItem = item.second
                    },
                    icon = {
                        Icon(imageVector = item.first, contentDescription = item.second)
                    },
                    label = {
                        Text(text = item.second)
                    },
                    alwaysShowLabel = true,
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = selectedItem)
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewNavigationRailContent() {
    MaterialAndroidForDevelopersTheme {
        NavigationRailContent()
    }
}