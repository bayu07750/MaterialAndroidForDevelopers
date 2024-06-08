// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ExposedDropdownMenuBoxContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuBoxContent(
    modifier: Modifier = Modifier,
    languages: List<String> = remember { DataDummy.listProgrammingLanguages },
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf(languages.first()) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        ExposedDropdownMenuBox(
            modifier = modifier,
            expanded = expanded,
            onExpandedChange = { expanded = it },
            content = {
                OutlinedTextField(
                    modifier = Modifier
                        .menuAnchor(),
                    value = selectedLanguage,
                    onValueChange = {},
                    readOnly = true,
                    label = {
                        Text(text = "Most used programming language")
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    content = {
                        languages.forEach { language ->
                            DropdownMenuItem(
                                text = { Text(text = language) },
                                onClick = {
                                    selectedLanguage = language
                                    expanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                )
            },
        )
    }
}

     """.trimIndent()
 }