// This should not be edited instead you can always generate using `source_code_generator.js`.


 object CheckBoxExampleContentSourceCode {
 
     val code get() = """
 
data class DataCheckbox(
    val label: String,
    val initialChecked: Boolean,
) {
    var checked by mutableStateOf(initialChecked)
}

@Composable
fun CheckBoxExampleContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val programmingLanguages = remember {
            DataDummy.listProgrammingLanguages.take(5).map {
                DataCheckbox(it, false)
            }
        }
        Text(text = "What is your favorite programming language?", style = MaterialTheme.typography.titleMedium)
        programmingLanguages.forEach { data ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = data.checked,
                        onClick = { data.checked = !data.checked },
                        role = Role.Checkbox
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = data.checked,
                    onCheckedChange = { data.checked = it }
                )
                Text(text = data.label)
            }
        }
    }
}

     """.trimIndent()
 }