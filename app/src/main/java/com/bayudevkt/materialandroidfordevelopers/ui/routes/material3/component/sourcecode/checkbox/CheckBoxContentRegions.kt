// This should not be edited instead you can always generate using `source_code_generator.js`.


 object CheckBoxContentSourceCode {
 
     val code get() = """
 
@Composable
fun CheckBoxContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(text = "Love Kotlin programming language?")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                enabled = false
            )
            Text(text = "Love Kotlin programming language?")
        }
    }
}

     """.trimIndent()
 }