package com.bayudevkt.materialandroidfordevelopers.m3components.model

import AlertDialogContentSourceCode
import AssistChipContentSourceCode
import BadgeContentSourceCode
import BasicAlertDialogContentSourceCode
import BottomAppBarContentSourceCode
import BottomAppBarWithScrollBehaviourContentSourceCode
import BottomSheetScaffoldContentSourceCode
import CardContentSourceCode
import CenterAlignedTopAppBarContentSourceCode
import CheckBoxContentSourceCode
import CheckBoxExampleContentSourceCode
import CircularProgressIndicatorContentSourceCode
import DatePickerContentSourceCode
import DateRangePickerContentSourceCode
import DismissibleNavigationDrawerContentSourceCode
import DockedSearchBarContentSourceCode
import DropDownMenuContentSourceCode
import ElevatedAssistChipContentSourceCode
import ElevatedButtonContentSourceCode
import ElevatedCardContentSourceCode
import ElevatedFilterChipContentSourceCode
import ElevatedSuggestionChipContentSourceCode
import ExposedDropdownMenuBoxContentSourceCode
import ExtendedFabContentSourceCode
import FabContentSourceCode
import FilledButtonContentSourceCode
import FilledIconButtonContentSourceCode
import FilledIconToggleButtonContentSourceCode
import FilledTonalIconButtonContentSourceCode
import FilledTonalIconToggleButtonContentSourceCode
import FilledTontalButtonContentSourceCode
import FilterChipContentSourceCode
import HorizontalDividerContentSourceCode
import HorizontalMultiBrowseCarouselContentSourceCode
import HorizontalUncontainedCarouselContentSourceCode
import IconButtonContentSourceCode
import IconToggleButtonContentSourceCode
import InputChipContentSourceCode
import LargeFabContentSourceCode
import LargeTopAppBarContentSourceCode
import LinearProgressIndicatorContentSourceCode
import ListItemContentSourceCode
import MediumTopAppBarContentSourceCode
import ModalBottomSheetContentSourceCode
import ModalNavigationDrawerContentSourceCode
import MultiChoiceSegmentedButtonRowContentSourceCode
import NavigationBarContentSourceCode
import NavigationRailContentSourceCode
import OutlinedButtonContentSourceCode
import OutlinedCardContentSourceCode
import OutlinedIconButtonContentSourceCode
import OutlinedIconToggleButtonContentSourceCode
import OutlinedTextFieldContentSourceCode
import PlainTooltipContentSourceCode
import RadioButtonContentSourceCode
import RangeSliderContentSourceCode
import RichTooltipContentSourceCode
import ScrollableTabRowContentSourceCode
import SearchBarContentSourceCode
import SingleChoiceSegmentedButtonRowContentSourceCode
import SliderContentSourceCode
import SliderWithCustomThumbContentSourceCode
import SliderWithStepContentSourceCode
import SmallFabContentSourceCode
import SnackbarContentSourceCode
import SnackbarWithActionContentSourceCode
import SuggestionChipContentSourceCode
import SwipeRefreshLayoutContentSourceCode
import SwitchContentSourceCode
import TabRowContentSourceCode
import TextButtonContentSourceCode
import TextFieldContentSourceCode
import TimePickerContentSourceCode
import TopAppBarContentSourceCode
import TopAppBarWithEnterAlwaysScrollBehaviourSourceCode
import TopAppBarWithExitUntilCollapsedScrollBehaviourSourceCode
import TopAppBarWithPinnedScrollBehaviourSourceCode
import TriStateCheckBoxContentSourceCode
import VerticalDividerContentSourceCode
import YoutubeModalBottomSheetContentSourceCode
import androidx.annotation.StringRes
import com.bayudevkt.materialandroidfordevelopers.core.ui.R
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import java.util.UUID

data class Component(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    @StringRes val description: Int? = null,
    val code: String = "",
    val subComponent: List<Component> = emptyList(),
)

data class CategoryComponent(val category: String)

/* region constant */
const val CATEGORY_ACTIONS = "Actions"
const val CATEGORY_COMMUNICATION = "Communication"
const val CATEGORY_CONTAINMENT = "Containment"
const val CATEGORY_NAVIGATION = "Navigation"
const val CATEGORY_SELECTION = "Selection"
const val CATEGORY_TEXT_INPUTS = "TextInputs"

const val BADGE = "Badge"
const val BOTTOM_APP_BAR = "BottomAppBar"
const val BOTTOM_APP_BAR_WITH_SCROLL_BEHAVIOUR = "BottomAppBarWithScrollBehaviour"
const val BOTTOM_SHEET_SCAFFOLD = "BottomSheetScaffold"
const val MODAL_BOTTOM_SHEET = "ModalBottomSheet"
const val YOUTUBE_MODAL_BOTTOM_SHEET = "YoutubeModalBottomSheet"
const val ELEVATED_BUTTON = "ElevatedButton"
const val FILLED_BUTTON = "FilledButton"
const val FILLED_TONAL_BUTTON = "FilledTonalButton"
const val MULTI_CHOICE_SEGMENTED_BUTTON_ROW = "MultiChoiceSegmentedButtonRow"
const val OUTLINED_BUTTON = "OutlinedButton"
const val SINGLE_CHOICE_SEGMENTED_BUTTON_ROW = "SingleChoiceSegmentedButtonRow"
const val TEXT_BUTTON = "TextButton"
const val CARD = "Card"
const val ELEVATED_CARD = "ElevatedCard"
const val OUTLINED_CARD = "OutlinedCard"
const val CHECK_BOX = "CheckBox"
const val CHECK_BOX_EXAMPLE = "CheckBoxExample"
const val TRI_STATE_CHECK_BOX = "TriStateCheckBox"
const val DATE_PICKER = "DatePicker"
const val DATE_PICKER_DIALOG = "DatePickerDialog"
const val DATE_RANGE_PICKER = "DateRangePicker"
const val ALERT_DIALOG = "AlertDialog"
const val BASIC_ALERT_DIALOG = "BasicAlertDialog"
const val HORIZONTAL_DIVIDER = "HorizontalDivider"
const val VERTICAL_DIVIDER = "VerticalDivider"
const val EXTENDED_FAB = "ExtendedFab"
const val FAB = "Fab"
const val LARGE_FAB = "LargeFab"
const val SMALL_FAB = "SmallFab"
const val FILLED_ICON_BUTTON = "FilledIconButton"
const val FILLED_ICON_TOGGLE_BUTTON = "FilledIconToggleButton"
const val FILLED_TONAL_ICON_BUTTON = "FilledTonalIconButton"
const val FILLED_TONAL_ICON_TOGGLE_BUTTON = "FilledTonalIconToggleButton"
const val ICON_BUTTON = "IconButton"
const val ICON_TOGGLE_BUTTON = "IconToggleButton"
const val OUTLINED_ICON_BUTTON = "OutlinedIconButton"
const val OUTLINED_ICON_TOGGLE_BUTTON = "OutlinedIconToggleButton"
const val LIST_ITEM = "ListItem"
const val DROP_DOWN_MENU = "DropDownMenu"
const val EXPOSED_DROPDOWN_MENU_BOX = "ExposedDropdownMenuBox"
const val NAVIGATION_BAR = "NavigationBar"
const val DISMISSIBLE_NAVIGATION_DRAWER = "DismissibleNavigationDrawer"
const val MODAL_NAVIGATION_DRAWER = "ModalNavigationDrawer"
const val NAVIGATION_RAIL = "NavigationRail"
const val CIRCULAR_PROGRESS_INDICATOR = "CircularProgressIndicator"
const val LINEAR_PROGRESS_INDICATOR = "LinearProgressIndicator"
const val RADIO_BUTTON = "RadioButton"
const val DOCKED_SEARCH_BAR = "DockedSearchBar"
const val SEARCH_BAR = "SearchBar"
const val SNACKBAR = "Snackbar"
const val SNACKBAR_WITH_ACTION = "SnackbarWithAction"
const val SWITCH = "Switch"
const val SCROLLABLE_TAB_ROW = "ScrollableTabRow"
const val TAB_ROW = "TabRow"
const val OUTLINED_TEXT_FIELD = "OutlinedTextField"
const val TEXT_FIELD = "TextField"
const val TIME_PICKER = "TimePicker"
const val CENTER_ALIGNED_TOP_APP_BAR = "CenterAlignedTopAppBar"
const val LARGE_TOP_APP_BAR = "LargeTopAppBar"
const val MEDIUM_TOP_APP_BAR = "MediumTopAppBar"
const val TOP_APP_BAR = "TopAppBar"
const val TOP_APP_BAR_WITH_ENTER_ALWAYS_SCROLL_BEHAVIOUR = "TopAppBarWithEnterAlwaysScrollBehaviour"
const val TOP_APP_BAR_WITH_EXIT_UNTIL_COLLAPSED_SCROLL_BEHAVIOUR = "TopAppBarWithExitUntilCollapsedScrollBehaviour"
const val TOP_APP_BAR_WITH_PINNED_SCROLL_BEHAVIOUR = "TopAppBarWithPinnedScrollBehaviour"
const val INPUT_CHIP = "InputChip"
const val FILTER_CHIP = "FilterChip"
const val ASSIST_CHIP = "AssistChip"
const val ELEVATED_ASSIST_CHIP = "ElevatedAssistChip"
const val ELEVATED_FILTER_CHIP = "ElevatedFilterChip"
const val ELEVATED_SUGGESTION_CHIP = "ElevatedSuggestionChip"
const val SUGGESTION_CHIP = "SuggestionChip"
const val PLAIN_TOOLTIP = "Tooltip"
const val RICH_TOOLTIP = "RichTooltip"
const val SLIDER = "Slider"
const val SLIDER_WITH_STEP = "SliderWithStep"
const val SLIDER_WITH_CUSTOM_THUMB = "SliderWithCustomThumb"
const val RANGE_SLIDER = "RangeSlider"
const val SWIPE_REFRESH_LAYOUT = "Pull To Refresh"
const val HORIZONTAL_MULTI_BROWSE_CAROUSEL = "HorizontalMultiBrowseCarousel"
const val HORIZONTAL_UNCONTAINED_CAROUSEL = "HorizontalUncontainedCarousel"

const val BOTTOM_APP_BARS = "BottomAppBars"
const val BOTTOM_SHEETS = "BottomSheets"
const val BUTTONS = "Buttons"
const val CARDS = "Cards"
const val CHECKBOXES = "Checkboxes"
const val DATE_PICKERS = "DatePickers"
const val DIALOGS = "Dialogs"
const val DIVIDERS = "Dividers"
const val FLOATING_ACTION_BUTTONS = "FloatingActionButtons"
const val ICON_BUTTONS = "IconButtons"
const val MENUS = "Menus"
const val NAVIGATION_BARS = "NavigationBars"
const val NAVIGATION_DRAWERS = "NavigationDrawers"
const val NAVIGATION_RAILS = "NavigationRails"
const val PROGRESS_INDICATORS = "ProgressIndicators"
const val SEARCH_BARS = "SearchBars"
const val TABS = "Tabs"
const val TEXT_FIELDS = "TextFields"
const val TOP_APP_BARS = "TopAppBars"
const val CHIPS = "Chips"
const val TOOLTIPS = "Tooltips"
const val SLIDERS = "Sliders"
const val SNACKBARS = "Snackbars"
const val CAROUSELS = "Carousels"

/* endregion constant */

val allAvailableComponents: List<String>
    get() = listOf(
        BADGE,
        BOTTOM_APP_BAR,
        BOTTOM_APP_BAR_WITH_SCROLL_BEHAVIOUR,
        BOTTOM_SHEET_SCAFFOLD,
        MODAL_BOTTOM_SHEET,
        YOUTUBE_MODAL_BOTTOM_SHEET,
        ELEVATED_BUTTON,
        FILLED_BUTTON,
        FILLED_TONAL_BUTTON,
        MULTI_CHOICE_SEGMENTED_BUTTON_ROW,
        OUTLINED_BUTTON,
        SINGLE_CHOICE_SEGMENTED_BUTTON_ROW,
        TEXT_BUTTON,
        CARD,
        ELEVATED_CARD,
        OUTLINED_CARD,
        CHECK_BOX,
        CHECK_BOX_EXAMPLE,
        TRI_STATE_CHECK_BOX,
        DATE_PICKER,
        DATE_PICKER_DIALOG,
        DATE_RANGE_PICKER,
        ALERT_DIALOG,
        BASIC_ALERT_DIALOG,
        HORIZONTAL_DIVIDER,
        VERTICAL_DIVIDER,
        EXTENDED_FAB,
        FAB,
        LARGE_FAB,
        SMALL_FAB,
        FILLED_ICON_BUTTON,
        FILLED_ICON_TOGGLE_BUTTON,
        FILLED_TONAL_ICON_BUTTON,
        FILLED_TONAL_ICON_TOGGLE_BUTTON,
        ICON_BUTTON,
        ICON_TOGGLE_BUTTON,
        OUTLINED_ICON_BUTTON,
        OUTLINED_ICON_TOGGLE_BUTTON,
        LIST_ITEM,
        DROP_DOWN_MENU,
        EXPOSED_DROPDOWN_MENU_BOX,
        NAVIGATION_BAR,
        DISMISSIBLE_NAVIGATION_DRAWER,
        MODAL_NAVIGATION_DRAWER,
        NAVIGATION_RAIL,
        CIRCULAR_PROGRESS_INDICATOR,
        LINEAR_PROGRESS_INDICATOR,
        RADIO_BUTTON,
        DOCKED_SEARCH_BAR,
        SEARCH_BAR,
        SNACKBAR,
        SNACKBAR_WITH_ACTION,
        SWITCH,
        SCROLLABLE_TAB_ROW,
        TAB_ROW,
        OUTLINED_TEXT_FIELD,
        TEXT_FIELD,
        TIME_PICKER,
        CENTER_ALIGNED_TOP_APP_BAR,
        LARGE_TOP_APP_BAR,
        MEDIUM_TOP_APP_BAR,
        TOP_APP_BAR,
        TOP_APP_BAR_WITH_ENTER_ALWAYS_SCROLL_BEHAVIOUR,
        TOP_APP_BAR_WITH_EXIT_UNTIL_COLLAPSED_SCROLL_BEHAVIOUR,
        TOP_APP_BAR_WITH_PINNED_SCROLL_BEHAVIOUR,
        INPUT_CHIP,
        FILTER_CHIP,
        ASSIST_CHIP,
        ELEVATED_ASSIST_CHIP,
        ELEVATED_FILTER_CHIP,
        ELEVATED_SUGGESTION_CHIP,
        SUGGESTION_CHIP,
        PLAIN_TOOLTIP,
        RICH_TOOLTIP,
        SLIDER,
        SLIDER_WITH_STEP,
        SLIDER_WITH_CUSTOM_THUMB,
        RANGE_SLIDER,
        SWIPE_REFRESH_LAYOUT,
    ).toImmutableList()

private val categoryActions
    get() =
        CategoryComponent(CATEGORY_ACTIONS) to listOf(
            Component(
                title = BUTTONS,
                description = R.string.button_desc,
                subComponent = listOf(
                    Component(
                        title = FILLED_BUTTON,
                        code = FilledButtonContentSourceCode.code,
                    ),
                    Component(title = TEXT_BUTTON, code = TextButtonContentSourceCode.code),
                    Component(title = OUTLINED_BUTTON, code = OutlinedButtonContentSourceCode.code),
                    Component(title = FILLED_TONAL_BUTTON, code = FilledTontalButtonContentSourceCode.code),
                    Component(title = ELEVATED_BUTTON, code = ElevatedButtonContentSourceCode.code),
                    Component(
                        title = SINGLE_CHOICE_SEGMENTED_BUTTON_ROW,
                        description = R.string.segmented_button_desc,
                        code = SingleChoiceSegmentedButtonRowContentSourceCode.code,
                    ),
                    Component(
                        title = MULTI_CHOICE_SEGMENTED_BUTTON_ROW,
                        description = R.string.segmented_button_desc,
                        code = MultiChoiceSegmentedButtonRowContentSourceCode.code,
                    ),
                )
            ),
            Component(
                title = FLOATING_ACTION_BUTTONS,
                description = R.string.fab_desc,
                subComponent = listOf(
                    Component(title = FAB, code = FabContentSourceCode.code),
                    Component(title = SMALL_FAB, code = SmallFabContentSourceCode.code),
                    Component(title = LARGE_FAB, code = LargeFabContentSourceCode.code),
                    Component(
                        title = EXTENDED_FAB,
                        description = R.string.extended_fab_desc,
                        code = ExtendedFabContentSourceCode.code,
                    ),
                )
            ),
            Component(
                title = ICON_BUTTONS,
                description = R.string.icon_button_desc,
                subComponent = listOf(
                    Component(title = ICON_BUTTON, code = IconButtonContentSourceCode.code),
                    Component(title = ICON_TOGGLE_BUTTON, code = IconToggleButtonContentSourceCode.code),
                    Component(title = FILLED_ICON_BUTTON, code = FilledIconButtonContentSourceCode.code),
                    Component(title = FILLED_ICON_TOGGLE_BUTTON, code = FilledIconToggleButtonContentSourceCode.code),
                    Component(title = FILLED_TONAL_ICON_BUTTON, code = FilledTonalIconButtonContentSourceCode.code),
                    Component(
                        title = FILLED_TONAL_ICON_TOGGLE_BUTTON,
                        code = FilledTonalIconToggleButtonContentSourceCode.code
                    ),
                    Component(title = OUTLINED_ICON_BUTTON, code = OutlinedIconButtonContentSourceCode.code),
                    Component(
                        title = OUTLINED_ICON_TOGGLE_BUTTON,
                        code = OutlinedIconToggleButtonContentSourceCode.code
                    ),
                )
            ),
        )

private val categoryCommunication
    get() =
        CategoryComponent(CATEGORY_COMMUNICATION) to listOf(
            Component(
                title = BADGE,
                description = R.string.badge_desc,
                code = BadgeContentSourceCode.code,
            ),
            Component(
                title = PROGRESS_INDICATORS,
                description = R.string.progress_desc,
                subComponent = listOf(
                    Component(
                        title = CIRCULAR_PROGRESS_INDICATOR,
                        code = CircularProgressIndicatorContentSourceCode.code
                    ),
                    Component(title = LINEAR_PROGRESS_INDICATOR, code = LinearProgressIndicatorContentSourceCode.code),
                )
            ),
            Component(
                title = SNACKBARS,
                description = R.string.snackbar_desc,
                subComponent = listOf(
                    Component(title = SNACKBAR, code = SnackbarContentSourceCode.code),
                    Component(title = SNACKBAR_WITH_ACTION, code = SnackbarWithActionContentSourceCode.code),
                )
            ),
            Component(
                title = TOOLTIPS,
                description = R.string.tooltips_desc,
                subComponent = listOf(
                    Component(
                        title = PLAIN_TOOLTIP,
                        code = PlainTooltipContentSourceCode.code,
                    ),
                    Component(
                        title = RICH_TOOLTIP,
                        code = RichTooltipContentSourceCode.code,
                    ),
                )
            ),
            Component(
                title = SWIPE_REFRESH_LAYOUT,
                description = null,
                code = SwipeRefreshLayoutContentSourceCode.code
            )
        )

private val categoryContainment
    get() =
        CategoryComponent(CATEGORY_CONTAINMENT) to listOf(
            Component(
                title = BOTTOM_SHEETS,
                description = R.string.bottom_sheets_desc,
                subComponent = listOf(
                    Component(title = BOTTOM_SHEET_SCAFFOLD, code = BottomSheetScaffoldContentSourceCode.code),
                    Component(title = MODAL_BOTTOM_SHEET, code = ModalBottomSheetContentSourceCode.code),
                    Component(title = YOUTUBE_MODAL_BOTTOM_SHEET, code = YoutubeModalBottomSheetContentSourceCode.code),
                )
            ),
            Component(
                title = CARDS,
                description = R.string.cards_desc,
                subComponent = listOf(
                    Component(title = CARD, code = CardContentSourceCode.code),
                    Component(title = ELEVATED_CARD, code = ElevatedCardContentSourceCode.code),
                    Component(title = OUTLINED_CARD, code = OutlinedCardContentSourceCode.code),
                )
            ),
            Component(
                title = DIALOGS,
                description = R.string.dialogs_desc,
                subComponent = listOf(
                    Component(title = ALERT_DIALOG, code = AlertDialogContentSourceCode.code),
                    Component(title = BASIC_ALERT_DIALOG, code = BasicAlertDialogContentSourceCode.code),
                )
            ),
            Component(
                title = DIVIDERS,
                description = R.string.dividers_desc,
                subComponent = listOf(
                    Component(title = HORIZONTAL_DIVIDER, code = HorizontalDividerContentSourceCode.code),
                    Component(title = VERTICAL_DIVIDER, code = VerticalDividerContentSourceCode.code),
                )
            ),
            Component(
                title = LIST_ITEM,
                description = R.string.list_item_desc,
                code = ListItemContentSourceCode.code,
            ),
            Component(
                title = CAROUSELS,
                description = R.string.carousels_desc,
                subComponent = listOf(
                    Component(
                        title = HORIZONTAL_MULTI_BROWSE_CAROUSEL,
                        code = HorizontalMultiBrowseCarouselContentSourceCode.code
                    ),
                    Component(
                        title = HORIZONTAL_UNCONTAINED_CAROUSEL,
                        code = HorizontalUncontainedCarouselContentSourceCode.code,
                    )
                ),
            )
        )

private val categoryNavigation
    get() =
        CategoryComponent(CATEGORY_NAVIGATION) to listOf(
            Component(
                title = BOTTOM_APP_BARS,
                description = R.string.bottom_app_bars_desc,
                subComponent = listOf(
                    Component(title = BOTTOM_APP_BAR, code = BottomAppBarContentSourceCode.code),
                    Component(
                        title = BOTTOM_APP_BAR_WITH_SCROLL_BEHAVIOUR,
                        code = BottomAppBarWithScrollBehaviourContentSourceCode.code
                    ),
                )
            ),
            Component(
                title = NAVIGATION_BARS,
                description = R.string.navigation_bars_desc,
                subComponent = listOf(
                    Component(title = NAVIGATION_BAR, code = NavigationBarContentSourceCode.code),
                )
            ),
            Component(
                title = NAVIGATION_DRAWERS,
                description = R.string.navigation_drawers_desc,
                subComponent = listOf(
                    Component(title = MODAL_NAVIGATION_DRAWER, code = ModalNavigationDrawerContentSourceCode.code),
                    Component(
                        title = DISMISSIBLE_NAVIGATION_DRAWER,
                        code = DismissibleNavigationDrawerContentSourceCode.code
                    ),
                )
            ),
            Component(
                title = NAVIGATION_RAIL,
                description = R.string.navigation_rail_desc,
                code = NavigationRailContentSourceCode.code,
            ),
            Component(
                title = SEARCH_BARS,
                description = R.string.search_bar_desc,
                subComponent = listOf(
                    Component(title = SEARCH_BAR, code = SearchBarContentSourceCode.code),
                    Component(title = DOCKED_SEARCH_BAR, code = DockedSearchBarContentSourceCode.code),
                )
            ),
            Component(
                title = TABS,
                description = R.string.tabs_desc,
                subComponent = listOf(
                    Component(title = TAB_ROW, code = TabRowContentSourceCode.code),
                    Component(title = SCROLLABLE_TAB_ROW, code = ScrollableTabRowContentSourceCode.code),
                )
            ),
            Component(
                title = TOP_APP_BARS,
                description = R.string.top_app_bars_desc,
                subComponent = listOf(
                    Component(title = TOP_APP_BAR, code = TopAppBarContentSourceCode.code),
                    Component(title = MEDIUM_TOP_APP_BAR, code = MediumTopAppBarContentSourceCode.code),
                    Component(title = LARGE_TOP_APP_BAR, code = LargeTopAppBarContentSourceCode.code),
                    Component(title = CENTER_ALIGNED_TOP_APP_BAR, code = CenterAlignedTopAppBarContentSourceCode.code),
                    Component(
                        title = TOP_APP_BAR_WITH_ENTER_ALWAYS_SCROLL_BEHAVIOUR,
                        code = TopAppBarWithEnterAlwaysScrollBehaviourSourceCode.code
                    ),
                    Component(
                        title = TOP_APP_BAR_WITH_EXIT_UNTIL_COLLAPSED_SCROLL_BEHAVIOUR,
                        code = TopAppBarWithExitUntilCollapsedScrollBehaviourSourceCode.code
                    ),
                    Component(
                        title = TOP_APP_BAR_WITH_PINNED_SCROLL_BEHAVIOUR,
                        code = TopAppBarWithPinnedScrollBehaviourSourceCode.code
                    ),
                )
            ),
        )
private val categorySelection
    get() =
        CategoryComponent(CATEGORY_SELECTION) to listOf(
            Component(
                title = CHECKBOXES,
                description = R.string.checkbox_desc,
                subComponent = listOf(
                    Component(title = CHECK_BOX, code = CheckBoxContentSourceCode.code),
                    Component(title = CHECK_BOX_EXAMPLE, code = CheckBoxExampleContentSourceCode.code),
                    Component(title = TRI_STATE_CHECK_BOX, code = TriStateCheckBoxContentSourceCode.code),
                )
            ),
            Component(
                title = CHIPS,
                description = R.string.chips_desc,
                subComponent = listOf(
                    Component(title = ASSIST_CHIP, code = AssistChipContentSourceCode.code),
                    Component(title = ELEVATED_ASSIST_CHIP, code = ElevatedAssistChipContentSourceCode.code),
                    Component(title = SUGGESTION_CHIP, code = SuggestionChipContentSourceCode.code),
                    Component(title = ELEVATED_SUGGESTION_CHIP, code = ElevatedSuggestionChipContentSourceCode.code),
                    Component(title = INPUT_CHIP, code = InputChipContentSourceCode.code),
                    Component(title = FILTER_CHIP, code = FilterChipContentSourceCode.code),
                    Component(title = ELEVATED_FILTER_CHIP, code = ElevatedFilterChipContentSourceCode.code),
                )
            ),
            Component(
                title = DATE_PICKERS,
                description = R.string.date_pickers_desc,
                subComponent = listOf(
                    Component(title = DATE_PICKER, code = DatePickerContentSourceCode.code),
                    Component(title = DATE_PICKER_DIALOG, code = DatePickerContentSourceCode.code),
                    Component(title = DATE_RANGE_PICKER, code = DateRangePickerContentSourceCode.code),
                )
            ),
            Component(
                title = MENUS,
                description = R.string.menus_desc,
                subComponent = listOf(
                    Component(title = DROP_DOWN_MENU, code = DropDownMenuContentSourceCode.code),
                    Component(title = EXPOSED_DROPDOWN_MENU_BOX, code = ExposedDropdownMenuBoxContentSourceCode.code),
                )
            ),
            Component(
                title = RADIO_BUTTON,
                description = R.string.radio_button_desc,
                code = RadioButtonContentSourceCode.code
            ),
            Component(
                title = SLIDERS,
                description = R.string.sliders_desc,
                subComponent = listOf(
                    Component(title = SLIDER, code = SliderContentSourceCode.code),
                    Component(title = SLIDER_WITH_STEP, code = SliderWithStepContentSourceCode.code),
                    Component(title = SLIDER_WITH_CUSTOM_THUMB, code = SliderWithCustomThumbContentSourceCode.code),
                    Component(title = RANGE_SLIDER, code = RangeSliderContentSourceCode.code),
                ),
            ),
            Component(
                title = SWITCH,
                description = R.string.switches_desc,
                code = SwitchContentSourceCode.code
            ),
            Component(
                title = TIME_PICKER,
                description = R.string.time_picker_desc,
                code = TimePickerContentSourceCode.code
            ),
        )

private val categoryTextInputs
    get() =
        CategoryComponent(CATEGORY_TEXT_INPUTS) to listOf(
            Component(
                title = TEXT_FIELDS,
                description = R.string.text_fields_desc,
                subComponent = listOf(
                    Component(title = TEXT_FIELD, code = TextFieldContentSourceCode.code),
                    Component(title = OUTLINED_TEXT_FIELD, code = OutlinedTextFieldContentSourceCode.code),
                )
            ),
        )

val availableMaterial3Components = mapOf(
    categoryActions,
    categoryCommunication,
    categoryContainment,
    categoryNavigation,
    categorySelection,
    categoryTextInputs,
).toImmutableMap()

fun getComponentByComponentName(componentName: String): Component? {
    return availableMaterial3Components.values.asSequence()
        .flatten()
        .mapNotNull { component ->
            component.takeIf { it.title == componentName }
                ?: component.subComponent.firstOrNull { it.title == componentName }
        }
        .firstOrNull()
}

fun main() {
}