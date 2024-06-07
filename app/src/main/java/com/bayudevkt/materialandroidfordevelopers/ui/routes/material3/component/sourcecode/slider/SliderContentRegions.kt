// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SliderContentSourceCode {
 
     val code get() = """
 
@Composable
fun SliderContent(
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
                valueRange = 1f..100f,
                steps = 0,
            )
            Text(text = )
        }
    }
}

     """.trimIndent()
 }