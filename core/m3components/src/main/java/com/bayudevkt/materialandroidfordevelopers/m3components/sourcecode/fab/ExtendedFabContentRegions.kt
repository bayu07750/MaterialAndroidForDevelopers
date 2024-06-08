// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ExtendedFabContentSourceCode {
 
     val code get() = """
 
@Composable
fun ExtendedFabContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ExtendedFloatingActionButton(
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Camera"
                )
            }
            ,
            text = {
                Text(text = "Compose")
            }
        )
    }
}

     """.trimIndent()
 }