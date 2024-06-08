package com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationdrawer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import kotlinx.coroutines.launch

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissibleNavigationDrawerContent(
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val drawerItems = remember {
        listOf(Icons.Default.Home, Icons.Default.Favorite, Icons.Default.Settings, Icons.Default.Help)
    }
    var selectedItem by remember { mutableStateOf(drawerItems.first()) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    DismissibleNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            DismissibleDrawerSheet(
                modifier = Modifier,
                drawerTonalElevation = 2.dp,
                drawerShape = MaterialTheme.shapes.large,
            ) {
                drawerItems.forEach { item ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                        label = {
                            Text(text = item.name.uppercase())
                        },
                        selected = item == selectedItem,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                selectedItem = item
                            }
                        },
                        icon = {
                            Icon(imageVector = item, contentDescription = item.name)
                        },
                        shape = MaterialTheme.shapes.medium
                    )
                }
            }
        },
        content = {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                contentWindowInsets = contentWindowInsets,
                topBar = {
                    TopAppBar(
                        title = { Text(text = selectedItem.name) },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    if (drawerState.isOpen) {
                                        drawerState.close()
                                    } else {
                                        drawerState.open()
                                    }
                                }
                            }) {
                                val icon = if (drawerState.currentValue == DrawerValue.Open) {
                                    Icons.Default.Close
                                } else Icons.Default.Menu
                                Icon(
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(imageVector = selectedItem, contentDescription = selectedItem.name)
                        Text(text = selectedItem.name)
                    }
                }
            }
        },
    )
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewDismissibleNavigationDrawerContent() {
    MaterialAndroidForDevelopersTheme {
        DismissibleNavigationDrawerContent()
    }
}