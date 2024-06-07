package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.colors

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.bayudevkt.materialandroidfordevelopers.ui.utils.LargeTopAppBarWithBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3ColorsRoute(
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            LargeTopAppBarWithBackButton(
                title = "Colors",
                onBack = onBack,
                scrollBehavior = scrollBehavior,
                onSettingsClicked = onSettingsClicked,
            )
        },
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
    ) {
        Material3ColorsContent(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        )
    }
}