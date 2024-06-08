// This should not be edited instead you can always generate using `source_code_generator.js`.


 object OutlinedButtonContentSourceCode {
 
     val code get() = """
 
@Composable
fun OutlinedButtonContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Button")
        }
        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Button")
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            enabled = false,
        ) {
            Text(text = "Button Disabled")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Save, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Button with Icon")
        }
    }
}

     """.trimIndent()
 }