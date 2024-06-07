package com.bayudevkt.materialandroidfordevelopers.ui.components.searchbar

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bayudevkt.materialandroidfordevelopers.ui.utils.DataDummy
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DockedSearchBarContent(
    modifier: Modifier = Modifier,
    data: List<String> = remember { DataDummy.listProgrammingLanguages },
    windowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
) {
    val lazyListState = rememberLazyListState()
    var items by remember(data) { mutableStateOf(data) }
    val itemsHistorySearch = remember { mutableStateListOf("c", "java") }
    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        contentWindowInsets = windowInsets,
        topBar = {
            var text by remember { mutableStateOf("") }
            var active by remember { mutableStateOf(false) }

            DockedSearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                query = text,
                onQueryChange = { text = it },
                onSearch = { query ->
                    active = false
                    items = data.filter { it.contains(query, true) }
                    if (itemsHistorySearch.indexOf(query) == -1) {
                        itemsHistorySearch.add(query)
                    }
                },
                active = active,
                onActiveChange = { active = it },
                placeholder = {
                    Text(text = "Search")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search Icon"
                    )
                },
                trailingIcon = {
                    if (active) {
                        IconButton(
                            onClick = {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    active = false
                                    items = data
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Rounded.Close, contentDescription = "Close Icon")
                        }
                    }
                },
                content = {
                    itemsHistorySearch.take(5).reversed().forEach { item ->
                        key(item) {
                            Surface(modifier = Modifier) {
                                Row(
                                    modifier = Modifier
                                        .clickable(
                                            role = Role.Button,
                                        ) {
                                            active = false
                                            text = item
                                            items = data.filter { it.contains(item, true) }
                                        }
                                        .semantics {
                                            contentDescription = "Search for $item"
                                        }
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.History,
                                        contentDescription = "History Icon"
                                    )
                                    Text(
                                        text = item,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            state = lazyListState,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = items, key = { it }) { item ->
                Surface(
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(context, item, Toast.LENGTH_SHORT)
                                .show()
                        }
                        .animateItemPlacement(),
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 3.dp,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewDockedSearchBarContent() {
    MaterialAndroidForDevelopersTheme {
        DockedSearchBarContent()
    }
}