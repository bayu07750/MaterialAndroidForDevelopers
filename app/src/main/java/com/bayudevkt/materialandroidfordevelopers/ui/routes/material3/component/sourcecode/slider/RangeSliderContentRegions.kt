// This should not be edited instead you can always generate using `source_code_generator.js`.


 object RangeSliderContentSourceCode {
 
     val code get() = """
 
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
                                Text(text = )
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
                                Text(text = )
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

     """.trimIndent()
 }