// This should not be edited instead you can always generate using `source_code_generator.js`.


 object HorizontalDividerContentSourceCode {
 
     val code get() = """
 
@Composable
fun HorizontalDividerContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            var thickness by remember { mutableFloatStateOf(0f) }
            Text(text = )
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                thickness = thickness.dp,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Change the thickness: ")
            Slider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = thickness,
                onValueChange = { thickness = it },
                valueRange = 1f..15f,
                steps = 15,
            )
        }
    }
}

     """.trimIndent()
 }