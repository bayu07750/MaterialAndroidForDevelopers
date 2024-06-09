package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.typography

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.bayudevkt.materialandroidfordevelopers.R
import com.bayudevkt.materialandroidfordevelopers.ui.utils.LargeTopAppBarWithBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypographyRoute(
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TypographyRoute(
        onBack = onBack,
        onSettingsClicked = onSettingsClicked,
        modifier = modifier,
        contentWindowInsets = TopAppBarDefaults.windowInsets
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TypographyRoute(
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
    contentWindowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        contentWindowInsets = contentWindowInsets,
        topBar = {
            LargeTopAppBarWithBackButton(
                title = stringResource(R.string.typography),
                onBack = onBack,
                scrollBehavior = scrollBehavior,
                onSettingsClicked = onSettingsClicked
            )
        },
    ) {
        TypographyContent(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        )
    }
}