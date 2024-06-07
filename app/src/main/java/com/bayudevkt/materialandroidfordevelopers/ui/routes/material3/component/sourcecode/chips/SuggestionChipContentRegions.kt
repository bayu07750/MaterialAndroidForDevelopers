// This should not be edited instead you can always generate using `source_code_generator.js`.


 object SuggestionChipContentSourceCode {
 
     val code get() = """
 
@Composable
fun SuggestionChipContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        SuggestionChip(
            onClick = {
                Toast.makeText(context, "Assist Chip", Toast.LENGTH_SHORT).show()
            },
            label = {
                Text(text = "Suggestion")
            },
        )
        SuggestionChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Suggestion")
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            },
        )
        SuggestionChip(
            onClick = { /*TODO*/ },
            label = {
                Text(text = "Suggestion")
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