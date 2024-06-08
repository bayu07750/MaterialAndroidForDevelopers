// This should not be edited instead you can always generate using `source_code_generator.js`.


 object FilledTontalButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun FilledTonalButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Button")
        }
        FilledTonalButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Button")
        }
        FilledTonalButton(
            onClick = { /*TODO*/ },
            enabled = false,
        ) {
            Text(text = "Button Disabled")
        }
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Save, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Button with Icon")
        }
    }
}

     """.trimIndent()
 }