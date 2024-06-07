// This should not be edited instead you can always generate using `source_code_generator.js`.


 object TriStateCheckBoxContentSourceCode {
 
     val code get() = """
 
@Composable
fun TriStateCheckBoxContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val items = remember {
            List(5) {
                DataCheckbox(label = (it + 1).toString(), initialChecked = false)
            }
        }

        val parentState = remember(
            keys = items.map { it.checked }.toTypedArray()
        ) {
            when {
                items.all { it.checked } -> ToggleableState.On
                items.none { it.checked } -> ToggleableState.Off
                else -> ToggleableState.Indeterminate
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    items.forEach {
                        it.checked = newState
                    }
                }
            )
            Text(text = "Numbers")
        }
        Column(
            modifier = Modifier.padding(start = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .toggleable(
                            value = item.checked,
                            role = Role.Checkbox,
                            onValueChange = { item.checked = it }
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Checkbox(
                        checked = item.checked,
                        onCheckedChange = { item.checked = it }
                    )
                    Text(text = item.label)
                }
            }
        }
    }
}

     """.trimIndent()
 }