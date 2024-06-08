// This should not be edited instead you can always generate using `source_code_generator.js`.


 object AssistChipContentSourceCode {
 
     val code get() = """
 
@Composable
fun AssistsChipContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        AssistChip(
            onClick = {
                Toast.makeText(context, "Assist Chip", Toast.LENGTH_SHORT).show()
            },
            label = {
                Text(text = "Assist")
            },
        )
        AssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Assist")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            }
        )
        AssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Assist")
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
        AssistChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Assist")
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