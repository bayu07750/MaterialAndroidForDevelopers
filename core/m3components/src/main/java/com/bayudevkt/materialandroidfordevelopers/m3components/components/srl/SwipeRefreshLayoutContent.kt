package com.bayudevkt.materialandroidfordevelopers.m3components.components.srl

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeRefreshLayoutContent(
    modifier: Modifier = Modifier,
) {
    var isRefreshing by remember { mutableStateOf(false) }
    val pullToRefreshState = rememberPullToRefreshState()
    val coroutineScope = rememberCoroutineScope()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            coroutineScope.launch {
                delay(2000)
                isRefreshing = false
            }
        },
        state = pullToRefreshState,
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (isRefreshing) {
            Text("Loading data...")
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(count = 100) { index ->
                    ListItem(
                        headlineContent = { Text(text = "Item $index") }
                    )
                }
            }
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewSwipeRefreshLayoutContent() {
    MaterialAndroidForDevelopersTheme {
        SwipeRefreshLayoutContent()
    }
}