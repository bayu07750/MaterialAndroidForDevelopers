package com.bayudevkt.materialandroidfordevelopers.m3components.components.badge

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

/* region */
@Composable
fun BadgeContent(
    modifier: Modifier = Modifier,
) {
    val items = remember {
        listOf(
            Icons.Rounded.Home to "Home",
            Icons.Rounded.Explore to "Explore",
            Icons.Rounded.Favorite to "Favorite",
        )
    }
    var selectedItem by remember { mutableStateOf(items.first().second) }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    selected = item.second == selectedItem,
                    onClick = {
                        selectedItem = item.second
                    },
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge {
                                    val badgeInt = 12
                                    Text(
                                        text = badgeInt.toString(),
                                        modifier = Modifier
                                    )
                                }
                            },
                            content = {
                                Icon(
                                    imageVector = item.first,
                                    contentDescription = item.second
                                )
                            }
                        )
                    },
                    label = {
                        Text(text = item.second)
                    },
                )
            }
        }
    }
}
/* endregion */