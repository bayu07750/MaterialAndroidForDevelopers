// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ElevatedButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun ElevatedButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Button")
        }
        ElevatedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Button")
        }
        ElevatedButton(
            onClick = { /*TODO*/ },
            enabled = false,
        ) {
            Text(text = "Button Disabled")
        }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Save, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Button with Icon")
        }
    }
}

     """.trimIndent()
 }