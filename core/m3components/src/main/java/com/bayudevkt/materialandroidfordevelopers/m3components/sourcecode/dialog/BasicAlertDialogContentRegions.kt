// This should not be edited instead you can always generate using `source_code_generator.js`.


 object BasicAlertDialogContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicAlertDialogContent(
    modifier: Modifier = Modifier,
    data: List<String> = remember { DataDummy.listProgrammingLanguages }
) {
    var dialogOpen by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Button(onClick = {
            dialogOpen = true
        }) {
            Text(text = "Show Dialog")
        }
    }

    if (dialogOpen) {
        var selectedLanguage by remember {
            mutableStateOf(DataDummy.listProgrammingLanguages.first())
        }

        BasicAlertDialog(
            onDismissRequest = {
                dialogOpen = false
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            )
        ) {
            Surface(
                modifier = Modifier
                    .heightIn(max = 500.dp),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation,
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "What is your favorite programming language?")
                    Divider()
                    Column(
                        modifier = Modifier
                            .verticalScroll(
                                state = rememberScrollState(),
                            )
                            .weight(1f)
                            .selectableGroup(),
                    ) {
                        data.forEach { language ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = selectedLanguage == language,
                                        onClick = {
                                            selectedLanguage = language
                                        }
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                RadioButton(
                                    selected = selectedLanguage == language,
                                    onClick = {
                                        selectedLanguage = language
                                    },
                                )
                                Text(text = language.uppercase(), style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                    Divider()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        val context = LocalContext.current
                        TextButton(onClick = {
                            Toast.makeText(context, selectedLanguage, Toast.LENGTH_SHORT).show()
                            dialogOpen = false
                        }) {
                            Text(text = "Ok")
                        }
                    }
                }
            }
        }
    }
}

     """.trimIndent()
 }