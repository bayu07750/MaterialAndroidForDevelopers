package com.bayudevkt.materialandroidfordevelopers.ui.components.slider

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bayudevkt.materialandroidfordevelopers.ui.theme.MaterialAndroidForDevelopersTheme

/* region */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RangeSliderContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        val rangeSliderState = remember {
            RangeSliderState(
                activeRangeStart = 1f,
                activeRangeEnd = 1000f,
                steps = 0,
                valueRange = 1f..1000f
            )
        }
        val startInteractionSource = remember {
            MutableInteractionSource()
        }
        val endInteractionSource = remember {
            MutableInteractionSource()
        }
        val startValue = rangeSliderState.activeRangeStart
        val endValue = rangeSliderState.activeRangeEnd
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            RangeSlider(
                state = rangeSliderState,
                startInteractionSource = startInteractionSource,
                endInteractionSource = endInteractionSource,
                startThumb = {
                    Label(
                        interactionSource = startInteractionSource,
                        label = {
                            PlainTooltip(
                                modifier = Modifier
                            ) {
                                Text(text = "${Math.round(startValue)}")
                            }
                        }
                    ) {
                        SliderDefaults.Thumb(
                            interactionSource = startInteractionSource,
                            colors = SliderDefaults.colors(),
                            enabled = true
                        )
                    }
                },
                endThumb = {
                    Label(
                        interactionSource = endInteractionSource,
                        label = {
                            PlainTooltip(
                                modifier = Modifier
                            ) {
                                Text(text = "${Math.round(endValue)}")
                            }
                        }
                    ) {
                        SliderDefaults.Thumb(
                            interactionSource = startInteractionSource,
                            colors = SliderDefaults.colors(),
                            enabled = true
                        )
                    }
                }
            )
        }
    }
}
/* endregion */

@Preview(showBackground = true)
@Composable
fun PreviewRangeSliderContent() {
    MaterialAndroidForDevelopersTheme {
        RangeSliderContent()
    }
}