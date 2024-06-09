package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component

import android.annotation.SuppressLint
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.ContentPaste
import androidx.compose.material.icons.rounded.Preview
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.amrdeveloper.codeview.CodeView
import com.bayudevkt.materialandroidfordevelopers.core.ui.R
import com.bayudevkt.materialandroidfordevelopers.m3components.RenderComponent
import com.bayudevkt.materialandroidfordevelopers.m3components.model.BOTTOM_APP_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.BOTTOM_APP_BAR_WITH_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.Component
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DATE_PICKER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DATE_PICKER_DIALOG
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DATE_RANGE_PICKER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DISMISSIBLE_NAVIGATION_DRAWER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DOCKED_SEARCH_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.MODAL_NAVIGATION_DRAWER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.NAVIGATION_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SEARCH_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TIME_PICKER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TOP_APP_BAR_WITH_ENTER_ALWAYS_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TOP_APP_BAR_WITH_EXIT_UNTIL_COLLAPSED_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TOP_APP_BAR_WITH_PINNED_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.getComponentByComponentName
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component.TabComponent.CODE
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component.TabComponent.PREVIEW
import com.bayudevkt.materialandroidfordevelopers.ui.utils.KotlinLanguage
import com.bayudevkt.materialandroidfordevelopers.ui.utils.LargeTopAppBarWithBackButton
import com.bayudevkt.materialandroidfordevelopers.utils.copyText
import kotlinx.coroutines.flow.collectLatest

private val listOfComponentsThatShouldNotHaveTopAppBar = listOf(
    TOP_APP_BAR_WITH_PINNED_SCROLL_BEHAVIOUR,
    TOP_APP_BAR_WITH_ENTER_ALWAYS_SCROLL_BEHAVIOUR,
    TOP_APP_BAR_WITH_EXIT_UNTIL_COLLAPSED_SCROLL_BEHAVIOUR,
    BOTTOM_APP_BAR,
    BOTTOM_APP_BAR_WITH_SCROLL_BEHAVIOUR,
    NAVIGATION_BAR,
    MODAL_NAVIGATION_DRAWER,
    DISMISSIBLE_NAVIGATION_DRAWER,
    DATE_PICKER,
    TIME_PICKER,
    DATE_PICKER_DIALOG,
    DATE_RANGE_PICKER,
    DOCKED_SEARCH_BAR,
    SEARCH_BAR,
)

enum class TabComponent(@StringRes val text: Int, val icon: ImageVector) {
    PREVIEW(R.string.preview, Icons.Rounded.Preview),
    CODE(R.string.code, Icons.Rounded.Code),
    EXPORT(R.string.export, Icons.Rounded.Code),
}

val TabComponentSaver
    get() = listSaver<TabComponent, Any>(
        save = {
            listOf(it.name)
        },
        restore = {
            TabComponent.valueOf(it[0] as String)
        }
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Material3ComponentDetailRoute(
    componentTitle: String,
    onComponentItemClicked: (String) -> Unit,
    onBack: () -> Unit,
    onSettingsClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val component = remember {
        getComponentByComponentName(componentTitle)
    }
    component?.let {
        val shouldNotUseScaffold = remember(componentTitle) {
            listOfComponentsThatShouldNotHaveTopAppBar.any { it == componentTitle }
        }
        var selectedTabComponent by remember { mutableStateOf(PREVIEW) }

        if (shouldNotUseScaffold) {
            // no need to check sub components
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                TabComponent(
                    onSelectedTabComponent = {
                        selectedTabComponent = it
                    },
                    modifier = Modifier.statusBarsPadding(),
                )
                PreviewAndCode(
                    snippetCode = component.code,
                    selectedTabComponent = selectedTabComponent,
                    component = component,
                )
            }
        } else {
            Scaffold(
                topBar = {
                    ConditionalTopAppBar(
                        componentTitle = componentTitle,
                        componentHaveSubs = component.subComponent.isNotEmpty(),
                        onBack = onBack,
                        scrollBehavior = scrollBehavior,
                        onSelectedTabComponent = {
                            selectedTabComponent = it
                        },
                        onSettingsClicked = onSettingsClicked,
                    )
                },
                modifier = modifier
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
            ) {
                val reusableModifier = Modifier.padding(it)
                when {
                    component.subComponent.isEmpty() -> {
                        PreviewAndCode(
                            snippetCode = component.code,
                            selectedTabComponent = selectedTabComponent,
                            component = component,
                            modifier = reusableModifier,
                        )
                    }

                    else -> {
                        ListComponents(
                            component = component,
                            onComponentItemClicked = onComponentItemClicked,
                            modifier = Modifier.padding(it),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PreviewAndCode(
    snippetCode: String,
    selectedTabComponent: TabComponent,
    component: Component,
    modifier: Modifier = Modifier,
) {
    when (selectedTabComponent) {
        TabComponent.EXPORT -> {}
        PREVIEW -> {
            RenderComponent(
                component.title,
                modifier,
            )
        }

        CODE -> {
            CodeView(
                snippetCode = snippetCode,
                modifier = modifier
                    .fillMaxSize(),
            )
        }
    }
}

@SuppressLint("InflateParams")
@Composable
fun CodeView(
    snippetCode: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .clickable(
                    role = Role.Button,
                    enabled = true,
                    onClick = {
                        context.copyText(snippetCode)
                    }
                )
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.6f))
                .padding(horizontal = 16.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Rounded.ContentPaste,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.copy_code),
                color = Color.White,
                style = MaterialTheme.typography.labelMedium,
            )
        }
        AndroidView(
            modifier = Modifier
                .fillMaxSize(),
            factory = { context ->
                val inflater = LayoutInflater.from(context)
                val codeView =
                    (inflater.inflate(com.bayudevkt.materialandroidfordevelopers.R.layout.code_view, null) as CodeView)
                codeView.setText(snippetCode)
                KotlinLanguage.applyFiveColorsDarkTheme(context, codeView)
                codeView
            },
        )
    }
}

@Composable
private fun ListComponents(
    component: Component,
    onComponentItemClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(top = 16.dp)
    ) {
        listComponents(
            components = component.subComponent,
            onComponentItemClicked = onComponentItemClicked
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConditionalTopAppBar(
    componentTitle: String,
    componentHaveSubs: Boolean,
    onBack: () -> Unit,
    onSelectedTabComponent: (TabComponent) -> Unit,
    onSettingsClicked: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    when (componentTitle) {
        in listOfComponentsThatShouldNotHaveTopAppBar -> {}
        else -> {
            Column {
                LargeTopAppBarWithBackButton(
                    title = componentTitle,
                    onBack = onBack,
                    scrollBehavior = scrollBehavior,
                    onSettingsClicked = onSettingsClicked,
                )
                if (componentHaveSubs.not()) {
                    TabComponent(
                        onSelectedTabComponent = onSelectedTabComponent
                    )
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TabComponent(
    onSelectedTabComponent: (TabComponent) -> Unit,
    modifier: Modifier = Modifier,
    tabs: List<TabComponent> = remember {
        listOf(PREVIEW, CODE)
    },
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        snapshotFlow { selectedTabIndex }
            .collectLatest {
                when (it) {
                    0 -> onSelectedTabComponent(tabs[0])
                    1 -> onSelectedTabComponent(tabs[1])
                }
            }
    }

    PrimaryTabRow(
        modifier = modifier,
        selectedTabIndex = selectedTabIndex,
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        tabs.forEachIndexed { index, tabComponent ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = {
                    selectedTabIndex = index
                },
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.height(48.dp),
                ) {
                    Icon(
                        imageVector = tabComponent.icon,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(id = tabComponent.text),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}
