// This should not be edited instead you can always generate using `source_code_generator.js`.


 object FilledTonalIconButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun FilledTonalIconButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FilledTonalIconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.DarkMode, contentDescription = "Location")
        }
        FilledTonalIconButton(onClick = { /*TODO*/ }, enabled = false) {
            Icon(imageVector = Icons.Default.DarkMode, contentDescription = "Location")
        }
    }
}

     """.trimIndent()
 }