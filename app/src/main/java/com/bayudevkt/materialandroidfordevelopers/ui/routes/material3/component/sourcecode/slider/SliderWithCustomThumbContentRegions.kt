// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SliderWithCustomThumbContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderWithCustomThumbContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        var value by remember { mutableFloatStateOf(0f) }
        val interactionSource = remember {
            MutableInteractionSource()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Slider(
                value = value,
                onValueChange = { value = it },
                valueRange = 1f..100f,
                steps = 0,
                interactionSource = interactionSource,
                thumb = {
                    Label(
                        label = {
                            RichTooltip(
                                title = {
                                    Text(text = "Thumb")
                                },
                                action = {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = null
                                    )
                                }
                            ) {
                                Text(text = )
                            }
                        },
                        interactionSource = interactionSource,
                    ) {
                        Surface {
                            Icon(
                                imageVector = Icons.Default.AirplanemodeActive,
                                contentDescription = null,
                            )
                        }
                    }
                }
            )
            Text(text = )
        }
    }
}

     """.trimIndent()
 }