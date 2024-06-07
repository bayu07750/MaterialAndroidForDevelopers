// This should not be edited instead you can always generate using `source_code_generator.js`.


 object FilledIconButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun FilledIconButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FilledIconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Location")
        }
        FilledIconButton(onClick = { /*TODO*/ }, enabled = false) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Location")
        }
    }
}

     """.trimIndent()
 }