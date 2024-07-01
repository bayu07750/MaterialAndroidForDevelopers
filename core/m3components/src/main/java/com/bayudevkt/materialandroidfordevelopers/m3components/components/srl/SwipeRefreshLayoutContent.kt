package com.bayudevkt.materialandroidfordevelopers.m3components.components.srl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.bayudevkt.materialandroidfordevelopers.core.ui.theme.MaterialAndroidForDevelopersTheme
import kotlinx.coroutines.delay

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeRefreshLayoutContent(
    modifier: Modifier = Modifier,
) {
    val pullToRefreshState = rememberPullToRefreshState()
    LaunchedEffect(pullToRefreshState.isRefreshing) {
        if (pullToRefreshState.isRefreshing) {
            delay(2000)
            pullToRefreshState.endRefresh()
        }
    }
    Box(
        modifier = modifier
            .nestedScroll(pullToRefreshState.nestedScrollConnection),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = 100) { index ->
                ListItem(
                    headlineContent = { Text(text = "Item $index") }
                )
            }
        }
        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier
                .align(Alignment.TopCenter),
        )
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