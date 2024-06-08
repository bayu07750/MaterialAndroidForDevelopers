// This should not be edited instead you can always generate using `source_code_generator.js`.


 object VerticalDividerContentSourceCode {
 
     val code get() = """
 
@Composable
fun VerticalDividerContent(
    modifier: Modifier = Modifier,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(),) {
        var thickness by remember { mutableFloatStateOf(0f) }
        Text(text = )
        Spacer(modifier = Modifier.height(8.dp))
        VerticalDivider(
            modifier = Modifier
                .weight(1f)
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

     """.trimIndent()
 }