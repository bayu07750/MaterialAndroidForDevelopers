// This should not be edited instead you can always generate using `source_code_generator.js`.


 object ElevatedSuggestionChipContentSourceCode {
 
     val code get() = """
 
@Composable
fun ElevatedSuggestionChipContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        ElevatedSuggestionChip(
            onClick = {
                Toast.makeText(context, "Assist Chip", Toast.LENGTH_SHORT).show()
            },
            label = {
                Text(text = "Elevated Suggestion")
            },
        )
        ElevatedSuggestionChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Suggestion")
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
        )
        ElevatedSuggestionChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Elevated Suggestion")
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
            enabled = false,
        )
    }
}

     """.trimIndent()
 }