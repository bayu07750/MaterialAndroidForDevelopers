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
import androidx.compose.foundation.layout.WindowInsets
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
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.radiobutton.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationdrawer.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationbar.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationrail.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.checkbox.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.badge.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.timepicker.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.datepicker.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.fab.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomappbar.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomsheet.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.dialog.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.listitem.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.divider.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.card.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.menus.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.snackbar.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.searchbar.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.switch.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.progressbar.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.tab.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.textfield.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.tooltip.*
import com.bayudevkt.materialandroidfordevelopers.m3components.components.slider.*
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ALERT_DIALOG
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ASSIST_CHIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.BADGE
import com.bayudevkt.materialandroidfordevelopers.m3components.model.BASIC_ALERT_DIALOG
import com.bayudevkt.materialandroidfordevelopers.m3components.model.BOTTOM_APP_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.BOTTOM_APP_BAR_WITH_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.BOTTOM_SHEET_SCAFFOLD
import com.bayudevkt.materialandroidfordevelopers.m3components.model.CARD
import com.bayudevkt.materialandroidfordevelopers.m3components.model.CENTER_ALIGNED_TOP_APP_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.CHECK_BOX
import com.bayudevkt.materialandroidfordevelopers.m3components.model.CHECK_BOX_EXAMPLE
import com.bayudevkt.materialandroidfordevelopers.m3components.model.CIRCULAR_PROGRESS_INDICATOR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.Component
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DATE_PICKER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DATE_PICKER_DIALOG
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DATE_RANGE_PICKER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DISMISSIBLE_NAVIGATION_DRAWER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DOCKED_SEARCH_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.DROP_DOWN_MENU
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ELEVATED_ASSIST_CHIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ELEVATED_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ELEVATED_CARD
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ELEVATED_FILTER_CHIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ELEVATED_SUGGESTION_CHIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.EXPOSED_DROPDOWN_MENU_BOX
import com.bayudevkt.materialandroidfordevelopers.m3components.model.EXTENDED_FAB
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FAB
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FILLED_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FILLED_ICON_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FILLED_ICON_TOGGLE_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FILLED_TONAL_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FILLED_TONAL_ICON_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FILLED_TONAL_ICON_TOGGLE_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.FILTER_CHIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.HORIZONTAL_DIVIDER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ICON_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.ICON_TOGGLE_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.INPUT_CHIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.LARGE_FAB
import com.bayudevkt.materialandroidfordevelopers.m3components.model.LARGE_TOP_APP_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.LINEAR_PROGRESS_INDICATOR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.LIST_ITEM
import com.bayudevkt.materialandroidfordevelopers.m3components.model.MEDIUM_TOP_APP_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.MODAL_BOTTOM_SHEET
import com.bayudevkt.materialandroidfordevelopers.m3components.model.MODAL_NAVIGATION_DRAWER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.MULTI_CHOICE_SEGMENTED_BUTTON_ROW
import com.bayudevkt.materialandroidfordevelopers.m3components.model.NAVIGATION_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.NAVIGATION_RAIL
import com.bayudevkt.materialandroidfordevelopers.m3components.model.OUTLINED_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.OUTLINED_CARD
import com.bayudevkt.materialandroidfordevelopers.m3components.model.OUTLINED_ICON_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.OUTLINED_ICON_TOGGLE_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.OUTLINED_TEXT_FIELD
import com.bayudevkt.materialandroidfordevelopers.m3components.model.PLAIN_TOOLTIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.RADIO_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.RANGE_SLIDER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.RICH_TOOLTIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SCROLLABLE_TAB_ROW
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SEARCH_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SINGLE_CHOICE_SEGMENTED_BUTTON_ROW
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SLIDER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SLIDER_WITH_CUSTOM_THUMB
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SLIDER_WITH_STEP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SMALL_FAB
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SNACKBAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SNACKBAR_WITH_ACTION
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SUGGESTION_CHIP
import com.bayudevkt.materialandroidfordevelopers.m3components.model.SWITCH
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TAB_ROW
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TEXT_BUTTON
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TEXT_FIELD
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TIME_PICKER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TOP_APP_BAR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TOP_APP_BAR_WITH_ENTER_ALWAYS_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TOP_APP_BAR_WITH_EXIT_UNTIL_COLLAPSED_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TOP_APP_BAR_WITH_PINNED_SCROLL_BEHAVIOUR
import com.bayudevkt.materialandroidfordevelopers.m3components.model.TRI_STATE_CHECK_BOX
import com.bayudevkt.materialandroidfordevelopers.m3components.model.VERTICAL_DIVIDER
import com.bayudevkt.materialandroidfordevelopers.m3components.model.YOUTUBE_MODAL_BOTTOM_SHEET
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
                val codeView = (inflater.inflate(com.bayudevkt.materialandroidfordevelopers.R.layout.code_view, null) as CodeView)
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

@Composable
fun RenderComponent(
    componentTitle: String,
    modifier: Modifier = Modifier,
) {
    when (componentTitle) {
        BADGE -> BadgeContent(modifier)
        BOTTOM_APP_BAR -> BottomAppBarContent(modifier)
        BOTTOM_APP_BAR_WITH_SCROLL_BEHAVIOUR -> BottomAppBarWithScrollBehaviourContent(modifier)
        BOTTOM_SHEET_SCAFFOLD -> BottomSheetScaffoldContent(modifier)
        ALERT_DIALOG -> AlertDialogContent(modifier)
        BASIC_ALERT_DIALOG -> BasicAlertDialogContent(modifier)
        MODAL_BOTTOM_SHEET -> ModalBottomSheetContent(modifier)
        ELEVATED_BUTTON -> ElevatedButtonContent(modifier)
        FILLED_BUTTON -> FilledButtonContent(modifier)
        FILLED_TONAL_BUTTON -> FilledTonalButtonContent(modifier)
        MULTI_CHOICE_SEGMENTED_BUTTON_ROW -> MultiChoiceSegmentedButtonRowContent(modifier)
        OUTLINED_BUTTON -> OutlinedButtonContent(modifier)
        SINGLE_CHOICE_SEGMENTED_BUTTON_ROW -> SingleChoiceSegmentedButtonRowContent(modifier)
        LIST_ITEM -> ListItemContent(modifier)
        TEXT_BUTTON -> TextButtonContent(modifier)
        CARD -> CardContent(modifier)
        ELEVATED_CARD -> ElevatedCardContent(modifier)
        OUTLINED_CARD -> OutlinedCardContent(modifier)
        CHECK_BOX -> CheckBoxContent(modifier)
        CHECK_BOX_EXAMPLE -> CheckBoxExampleContent(modifier)
        TRI_STATE_CHECK_BOX -> TriStateCheckBoxContent(modifier)
        DATE_PICKER -> DatePickerContent(modifier)
        DATE_RANGE_PICKER -> DateRangePickerContent(modifier)
        DATE_PICKER_DIALOG -> DatePickerDialogContent(modifier)
        HORIZONTAL_DIVIDER -> HorizontalDividerContent(modifier)
        VERTICAL_DIVIDER -> VerticalDividerContent(modifier)
        EXTENDED_FAB -> ExtendedFabContent(modifier)
        FAB -> FabContent(modifier)
        LARGE_FAB -> LargeFabContent(modifier)
        SMALL_FAB -> SmallFabContent(modifier)
        FILLED_ICON_BUTTON -> FilledIconButtonContent(modifier)
        FILLED_ICON_TOGGLE_BUTTON -> FilledIconToggleButtonContent(modifier)
        FILLED_TONAL_ICON_BUTTON -> FilledTonalIconButtonContent(modifier)
        FILLED_TONAL_ICON_TOGGLE_BUTTON -> FilledTonalIconToggleButtonContent(modifier)
        ICON_BUTTON -> IconButtonContent(modifier)
        ICON_TOGGLE_BUTTON -> IconToggleButtonContent(modifier)
        OUTLINED_ICON_BUTTON -> OutlinedIconButtonContent(modifier)
        OUTLINED_ICON_TOGGLE_BUTTON -> OutlinedIconToggleButtonContent(modifier)
        DROP_DOWN_MENU -> DropDownMenuContent(modifier)
        EXPOSED_DROPDOWN_MENU_BOX -> ExposedDropdownMenuBoxContent(modifier)
        NAVIGATION_BAR -> NavigationBarContent(modifier)
        DISMISSIBLE_NAVIGATION_DRAWER -> DismissibleNavigationDrawerContent(modifier)
        MODAL_NAVIGATION_DRAWER -> ModalNavigationDrawerContent(modifier)
        NAVIGATION_RAIL -> NavigationRailContent(modifier)
        CIRCULAR_PROGRESS_INDICATOR -> CircularProgressIndicatorContent(modifier)
        LINEAR_PROGRESS_INDICATOR -> LinearProgressIndicatorContent(modifier)
        RADIO_BUTTON -> RadioButtonContent(modifier)
        DOCKED_SEARCH_BAR ->
            DockedSearchBarContent(modifier, windowInsets = WindowInsets(0.dp))

        SEARCH_BAR -> SearchBarContent(modifier, contentWindowInsets = WindowInsets(0.dp))
        SNACKBAR -> SnackbarContent(modifier)
        SNACKBAR_WITH_ACTION -> SnackbarWithActionContent(modifier)
        SWITCH -> SwitchContent(modifier)
        SCROLLABLE_TAB_ROW -> ScrollableTabRowContent(modifier)
        TAB_ROW -> TabRowContent(modifier)
        OUTLINED_TEXT_FIELD -> OutlinedTextFieldContent(modifier)
        TEXT_FIELD -> TextFieldContent(modifier)
        TIME_PICKER -> TimePickerContent(modifier)
        CENTER_ALIGNED_TOP_APP_BAR -> CenterAlignedTopAppBarContent(modifier)
        LARGE_TOP_APP_BAR -> LargeTopAppBarContent(modifier)
        MEDIUM_TOP_APP_BAR -> MediumTopAppBarContent(modifier)
        TOP_APP_BAR -> TopAppBarContent(modifier)
        TOP_APP_BAR_WITH_ENTER_ALWAYS_SCROLL_BEHAVIOUR -> TopAppBarWithEnterAlwaysScrollBehaviour(modifier)
        TOP_APP_BAR_WITH_EXIT_UNTIL_COLLAPSED_SCROLL_BEHAVIOUR -> TopAppBarWithExitUntilCollapsedScrollBehaviour(
            modifier
        )

        TOP_APP_BAR_WITH_PINNED_SCROLL_BEHAVIOUR -> TopAppBarWithPinnedScrollBehaviour(modifier)
        YOUTUBE_MODAL_BOTTOM_SHEET -> YoutubeModalBottomSheetContent(modifier)
        ASSIST_CHIP -> AssistsChipContent(modifier)
        ELEVATED_ASSIST_CHIP -> ElevatedAssistChipContent(modifier)
        SUGGESTION_CHIP -> SuggestionChipContent(modifier)
        ELEVATED_SUGGESTION_CHIP -> ElevatedSuggestionChipContent(modifier)
        INPUT_CHIP -> InputChipContent(modifier)
        FILTER_CHIP -> FilterChipContent(modifier)
        ELEVATED_FILTER_CHIP -> ElevatedFilterChipContent(modifier)
        PLAIN_TOOLTIP -> PlainTooltipContent(modifier)
        RICH_TOOLTIP -> RichTooltipContent(modifier)
        SLIDER -> SliderContent(modifier)
        SLIDER_WITH_STEP -> SliderWithStepContent(modifier)
        SLIDER_WITH_CUSTOM_THUMB -> SliderWithCustomThumbContent(modifier)
        RANGE_SLIDER -> RangeSliderContent(modifier)
        else -> {}
    }
}
