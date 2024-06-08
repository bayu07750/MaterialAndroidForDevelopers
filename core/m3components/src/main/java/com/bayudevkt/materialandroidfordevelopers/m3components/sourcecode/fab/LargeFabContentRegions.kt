// This should not be edited instead you can always generate using `source_code_generator.js`.


 object LargeFabContentSourceCode {
 
     val code get() = """
 
@Composable
fun LargeFabContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LargeFloatingActionButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null
            )
        }
    }
}

     """.trimIndent()
 }