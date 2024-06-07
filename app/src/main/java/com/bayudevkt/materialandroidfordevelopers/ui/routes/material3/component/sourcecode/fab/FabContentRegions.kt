// This should not be edited instead you can always generate using `source_code_generator.js`.


 object FabContentSourceCode {
 
     val code get() = """
 
@Composable
fun FabContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FloatingActionButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.Default.Camera,
                contentDescription = null
            )
        }
    }
}

     """.trimIndent()
 }