// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SliderWithStepContentSourceCode {
 
     val code get() = """
 
@Composable
fun SliderWithStepContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        var value by remember { mutableFloatStateOf(0f) }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Slider(
                value = value,
                onValueChange = { value = it },
                valueRange = 0f..100f,
                steps = 10,
            )
            Text(text = )
        }
    }
}

     """.trimIndent()
 }