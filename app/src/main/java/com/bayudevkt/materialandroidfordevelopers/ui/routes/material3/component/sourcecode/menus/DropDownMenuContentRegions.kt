// This should not be edited instead you can always generate using `source_code_generator.js`.


 object DropDownMenuContentSourceCode {
 
     val code get() = """
 
@Composable
fun DropDownMenuContent(
    modifier: Modifier = Modifier,
    data: List<DataDropdownMenu> = remember {
        DataDummy.dataDropdownMenu
    }
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var open by remember { mutableStateOf(false) }
        val context = LocalContext.current
        Button(onClick = {
            open = true
        }) {
            Text(text = "Show Dropdown Menu")
        }
        DropdownMenu(
            modifier = Modifier,
            expanded = open,
            onDismissRequest = { open = false },
            properties = PopupProperties(),
            content = {
                data.forEachIndexed { index, menu ->
                    DropdownMenuItem(
                        text = {
                            Text(text = menu.text)
                        },
                        onClick = {
                            Toast.makeText(context, menu.text, Toast.LENGTH_SHORT).show()
                            open = false
                        },
                        leadingIcon = {
                            Icon(imageVector = menu.icon, contentDescription = menu.icon.name)
                        },
                        trailingIcon = {
                            if (index == 0) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
                            }
                        },
                        enabled = index != data.lastIndex,
                        contentPadding = PaddingValues(horizontal = 24.dp)
                    )
                }
            }
        )
    }
}

     """.trimIndent()
 }