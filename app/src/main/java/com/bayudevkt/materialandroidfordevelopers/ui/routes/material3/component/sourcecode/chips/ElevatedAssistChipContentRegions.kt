// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ElevatedAssistChipContentSourceCode {
 
     val code get() = """
 
@Composable
fun ElevatedAssistChipContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        ElevatedAssistChip(
            onClick = {
                Toast.makeText(context, "Elevated Assist", Toast.LENGTH_SHORT).show()
            },
            label = {
                Text(text = "Assist")
            },
        )
        ElevatedAssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            }
        )
        ElevatedAssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(Icons.Rounded.Check, null)
            }
        )
        ElevatedAssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(Icons.Rounded.Check, null)
            },
            enabled = false,
        )
    }
}

     """.trimIndent()
 }