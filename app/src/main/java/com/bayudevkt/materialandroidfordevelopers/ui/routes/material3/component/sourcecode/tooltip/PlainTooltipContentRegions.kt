// This should not be edited instead you can always generate using `source_code_generator.js`.


 object PlainTooltipContentSourceCode {
 
     val code get() = """
 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlainTooltipContent(
    modifier: Modifier = Modifier,
) {
    val tooltipState = rememberTooltipState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip(
                        caretProperties = TooltipDefaults.caretProperties,

                    ) {
                        Text(text = "Hello World!")
                    }
                },
                state = tooltipState,
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Press me!")
                }
            }
            Button(onClick = {
                scope.launch {
                    tooltipState.show()
                }
            }) {
                Text(text = "Show tooltip")
            }
        }
    }
}

     """.trimIndent()
 }