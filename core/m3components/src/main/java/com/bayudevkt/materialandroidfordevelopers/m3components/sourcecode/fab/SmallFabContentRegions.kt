// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SmallFabContentSourceCode {
 
     val code get() = """
 
@Composable
fun SmallFabContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SmallFloatingActionButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }
}

     """.trimIndent()
 }