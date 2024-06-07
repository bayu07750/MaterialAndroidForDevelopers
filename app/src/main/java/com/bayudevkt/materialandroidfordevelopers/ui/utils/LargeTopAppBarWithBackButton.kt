package com.bayudevkt.materialandroidfordevelopers.ui.utils

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.defaultLargeTopAppBarColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarWithBackButton(
    title: String,
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.secondaryContainer),
        shadowElevation = 2.dp
    ) {
        LargeTopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = title,
                    modifier = Modifier.basicMarquee()
                )
            },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = onSettingsClicked) {
                    Icon(
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = null
                    )
                }
            },
            scrollBehavior = scrollBehavior,
            colors = defaultLargeTopAppBarColors(),
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainLargeTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onSettingsClicked: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
) {
    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.secondaryContainer),
        shadowElevation = 2.dp
    ) {
        LargeTopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = title,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .basicMarquee()
                )
            },
            scrollBehavior = scrollBehavior,
            colors = defaultLargeTopAppBarColors(),
            actions = {
                IconButton(onClick = onSettingsClicked) {
                    Icon(
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = null
                    )
                }
            }
        )
    }
}
