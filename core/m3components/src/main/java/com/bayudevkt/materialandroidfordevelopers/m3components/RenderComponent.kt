package com.bayudevkt.materialandroidfordevelopers.m3components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.m3components.components.badge.BadgeContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomappbar.BottomAppBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomappbar.BottomAppBarWithScrollBehaviourContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomsheet.BottomSheetScaffoldContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomsheet.ModalBottomSheetContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.bottomsheet.YoutubeModalBottomSheetContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.ElevatedButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.FilledButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.FilledTonalButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.MultiChoiceSegmentedButtonRowContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.OutlinedButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.SingleChoiceSegmentedButtonRowContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.button.TextButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.card.CardContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.card.ElevatedCardContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.card.OutlinedCardContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.checkbox.CheckBoxContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.checkbox.CheckBoxExampleContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.checkbox.TriStateCheckBoxContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.AssistsChipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.ElevatedAssistChipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.ElevatedFilterChipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.ElevatedSuggestionChipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.FilterChipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.InputChipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.chips.SuggestionChipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.datepicker.DatePickerContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.datepicker.DatePickerDialogContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.datepicker.DateRangePickerContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.dialog.AlertDialogContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.dialog.BasicAlertDialogContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.divider.HorizontalDividerContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.divider.VerticalDividerContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.fab.ExtendedFabContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.fab.FabContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.fab.LargeFabContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.fab.SmallFabContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.FilledIconButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.FilledIconToggleButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.FilledTonalIconButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.FilledTonalIconToggleButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.IconButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.IconToggleButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.OutlinedIconButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.iconbutton.OutlinedIconToggleButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.listitem.ListItemContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.menus.DropDownMenuContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.menus.ExposedDropdownMenuBoxContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationbar.NavigationBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationdrawer.DismissibleNavigationDrawerContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationdrawer.ModalNavigationDrawerContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.navigationrail.NavigationRailContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.progressbar.CircularProgressIndicatorContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.progressbar.LinearProgressIndicatorContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.radiobutton.RadioButtonContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.searchbar.DockedSearchBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.searchbar.SearchBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.slider.RangeSliderContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.slider.SliderContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.slider.SliderWithCustomThumbContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.slider.SliderWithStepContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.snackbar.SnackbarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.snackbar.SnackbarWithActionContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.switch.SwitchContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.tab.ScrollableTabRowContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.tab.TabRowContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.textfield.OutlinedTextFieldContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.textfield.TextFieldContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.timepicker.TimePickerContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.tooltip.PlainTooltipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.tooltip.RichTooltipContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.CenterAlignedTopAppBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.LargeTopAppBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.MediumTopAppBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.TopAppBarContent
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.TopAppBarWithEnterAlwaysScrollBehaviour
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.TopAppBarWithExitUntilCollapsedScrollBehaviour
import com.bayudevkt.materialandroidfordevelopers.m3components.components.topappbar.TopAppBarWithPinnedScrollBehaviour
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