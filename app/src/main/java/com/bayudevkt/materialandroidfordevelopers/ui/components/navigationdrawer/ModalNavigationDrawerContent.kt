package com.bayudevkt.materialandroidfordevelopers.ui.components.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.R
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme
import kotlinx.coroutines.launch

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalNavigationDrawerContent(
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val scope = rememberCoroutineScope()
    val drawerItems = remember {
        listOf(
            Icons.Default.Add to "New Chat",
            Icons.Default.History to "History",
            Icons.Default.Settings to "Settings",
            Icons.AutoMirrored.Filled.Help to "Help Center",
        )
    }
    var selectedItem by remember { mutableStateOf(drawerItems.first().second) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                val padModifier = Modifier
                    .padding(horizontal = 16.dp)
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = padModifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column {
                        Text(
                            text = "Your Name?",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium)
                        )
                        Text(
                            text = "Enter Email",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    modifier = padModifier,
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 5.dp,
                ) {
                    Text(
                        text = "Free Plan",
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                HorizontalDivider(modifier = padModifier)
                Spacer(modifier = Modifier.height(8.dp))
                drawerItems.take(2).forEach { data ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        label = { Text(text = data.second) },
                        icon = { Icon(imageVector = data.first, contentDescription = data.second) },
                        selected = data.second == selectedItem,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem = data.second
                        }
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                HorizontalDivider(modifier = padModifier)
                Spacer(modifier = Modifier.height(8.dp))
                drawerItems.takeLast(2).forEach { data ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        label = { Text(text = data.second) },
                        icon = { Icon(imageVector = data.first, contentDescription = data.second) },
                        selected = data.second == selectedItem,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem = data.second
                        }
                    )
                }
            }
        },
        content = {
            Scaffold(
                modifier = modifier,
                contentWindowInsets = contentWindowInsets,
                topBar = {
                    TopAppBar(
                        title = { },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            }
                        }
                    )
                }
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = selectedItem)
                }
            }
        }
    )
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewModalNavigationDrawerContent() {
    MaterialAndroidForDevelopersTheme {
        ModalNavigationDrawerContent()
    }
}