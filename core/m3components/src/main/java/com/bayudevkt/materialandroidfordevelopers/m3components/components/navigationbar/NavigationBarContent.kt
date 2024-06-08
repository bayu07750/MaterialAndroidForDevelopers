package com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Subscriptions
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@Composable
fun NavigationBarContent(
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val items = remember {
        listOf(
            Icons.Default.Home to "Home",
            Icons.Default.Explore to "Explore",
            Icons.Default.Subscriptions to "Subscriptions",
            Icons.Default.VideoLibrary to "Library",
        )
    }
    var selectedLibrary by remember { mutableStateOf(items.first().second) }
    Scaffold(
        modifier = modifier,
        contentWindowInsets = contentWindowInsets,
        bottomBar = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                NavigationBar {
                    items.forEach { item ->
                        NavigationBarItem(
                            selected = item.second == selectedLibrary,
                            onClick = {
                                selectedLibrary = item.second
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
                NavigationBar {
                    items.forEach { item ->
                        NavigationBarItem(
                            selected = item.second == selectedLibrary,
                            onClick = {
                                selectedLibrary = item.second
                            },
                            icon = {
                                Icon(imageVector = item.first, contentDescription = item.second)
                            },
                            label = {
                                Text(text = item.second)
                            },
                            alwaysShowLabel = false,
                        )
                    }
                }
                NavigationBar {
                    items.forEach { item ->
                        NavigationBarItem(
                            selected = item.second == selectedLibrary,
                            onClick = {
                                selectedLibrary = item.second
                            },
                            icon = {
                                Icon(imageVector = item.first, contentDescription = item.second)
                            },
                            label = {
                                Text(text = item.second)
                            },
                            alwaysShowLabel = false,
                            enabled = false
                        )
                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = selectedLibrary)
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewNavigationBar() {
    MaterialAndroidForDevelopersTheme {
        NavigationBarContent()
    }
}