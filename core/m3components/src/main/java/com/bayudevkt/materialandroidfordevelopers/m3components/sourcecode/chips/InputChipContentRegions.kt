// This should not be edited instead you can always generate using `source_code_generator.js`.


 object InputChipContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InputChipContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = "Choose your interests")
        var selected1 by remember { mutableStateOf(false) }
        var selected2 by remember { mutableStateOf(false) }
        var selected3 by remember { mutableStateOf(false) }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InputChip(
                selected = selected1,
                onClick = {
                    selected1 = !selected1
                },
                label = {
                    Text(text = "TV")
                },
            )
            InputChip(
                selected = selected2,
                onClick = {
                    selected2 = !selected2
                },
                label = {
                    Text(text = "Movie")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Movie,
                        contentDescription = null
                    )
                }
            )
            InputChip(
                selected = selected3,
                onClick = {
                    selected3 = !selected3
                },
                label = {
                    Text(text = "Both")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Movie,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Tv,
                        contentDescription = null
                    )
                }
            )
            InputChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text(text = "Other")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Favorite,
                        contentDescription = null
                    )
                },
                enabled = false,
            )
        }
    }
}

     """.trimIndent()
 }